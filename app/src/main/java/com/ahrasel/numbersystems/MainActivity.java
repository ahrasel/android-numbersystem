package com.ahrasel.numbersystems;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.ahrasel.numbersystems.Fragments.ConvertNumberFM;
import com.ahrasel.numbersystems.Fragments.NumberCalculatioFM;
import com.ahrasel.numbersystems.Fragments.RecyclerViewFM;
import com.google.android.gms.ads.AdView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.adView) AdView _adView;
    @BindView(R.id.fragment_Container) FrameLayout _fragmentContainer;
    private Toolbar toolbar;
    private boolean isHomeFragment;
    private static final String ASCII_TITLE = "ASCII COdes";
    private static final String BCD_TITLE = "BCD COdes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        changeFragment("Convert Number", new ConvertNumberFM());
        //Intilize Google Admob Add
        intilizeAdmobAd();

    }

    private void intilizeAdmobAd() {

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        if (!isHomeFragment){
            changeFragment("Convert Number", new ConvertNumberFM());
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.nav_convert_number: changeFragment("Convert Number", new ConvertNumberFM());break;
            case R.id.nav_Number_calculation: changeFragment("Calculate Number", new NumberCalculatioFM()); break;
            case R.id.nav_all_ascii_code: changeFragment(ASCII_TITLE, new RecyclerViewFM()); break;
            case R.id.nav_bcd_code:  changeFragment(BCD_TITLE, new RecyclerViewFM()); break;
            case R.id.nav_share: showShareAction(); break;
            case R.id.nav_rateus: showRateApplication(); break;
            default: break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        this.isHomeFragment = false;
        return true;
    }

    private void showRateApplication() {
        Uri uri = Uri.parse("market://details?id=" + this.getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
        }
    }

    private void showShareAction() {
        //mShareActionProvider = (ShareActionProvider) item.getActionProvider();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT,"Share App With Your Friend");
        //sendIntent.putExtra(Intent.EXTRA_TEXT, R.string.share_actionlink_text);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey check out our app at: https://play.google.com/store/apps/details?id=" + this.getPackageName());
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    private void changeFragment(String tolbarTitle, Fragment fragment) {
        toolbar.setTitle(tolbarTitle);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_Container,fragment);
        //transaction.addToBackStack(null);
        transaction.commit();

    }
}
