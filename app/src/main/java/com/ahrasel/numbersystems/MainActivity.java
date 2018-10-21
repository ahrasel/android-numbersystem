package com.ahrasel.numbersystems;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
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
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ahrasel.numbersystems.Fragments.AsciiCodesFM;
import com.ahrasel.numbersystems.Fragments.BcdCodesFM;
import com.ahrasel.numbersystems.Fragments.ConvertNumberFM;
import com.ahrasel.numbersystems.Fragments.NumberCalculatioFM;
import com.ahrasel.numbersystems.Models.RecyclerLayoutController;
import com.ahrasel.numbersystems.Prefs.AddControllPrefs;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, RecyclerLayoutController {

    private static final String ADMOB_APP_ID = "ca-app-pub-7674076163572757~5657248764";
    private static final String ADMOB_INTERESTIAL_CODE = "ca-app-pub-7674076163572757/7009858887";
    private  int NavigationviewId;
    private Toolbar toolbar;
    private boolean isHomeFragment;
    private static final String ASCII_TITLE = "ASCII Codes";
    private static final String BCD_TITLE = "BCD Codes";
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private AddControllPrefs prefs;
    private static final long GAME_LENGTH_MILLISECONDS = 1000*60*5;
    private CountDownTimer countDownTimer;
    private long timerMillisecond;

    @Override
    protected void onPause() {
        //countDownTimer.cancel();
        super.onPause();
    }

    @Override
    protected void onStop() {
       // prefs.setFirstRun(false);
        //finish();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        prefs.setFirstRun(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //create Instence And Obj
        createObj();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toolbar.setTitle(R.string.convertnumbertitle);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_Container,new ConvertNumberFM());
        //transaction.addToBackStack(null);
        transaction.commit();

        //Intilize Google Admob Add
        intilizeAdmobAd();
        //Intilize Baner Add
        initilizeBanerAdd();
        //Interestial Add
        showInterestialAd();

        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                loadInterestilaAdd();
                countDownTimer.start();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                loadInterestilaAdd();
                super.onAdFailedToLoad(i);
            }
        });

        //create timer
        createTimer(GAME_LENGTH_MILLISECONDS);

        if (prefs.isFirstRun()){
            countDownTimer.start();
        }

    }

    private void createObj() {
        prefs = new AddControllPrefs(this);
    }

    private void createTimer(final long milliseconds) {
        // Create the game timer, which counts down to the end of the level
        // and shows the "retry" button.
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        countDownTimer = new CountDownTimer(milliseconds, 50) {
            @Override
            public void onTick(long millisUnitFinished) {
                timerMillisecond = millisUnitFinished;
//                Toast.makeText(MainActivity.this, "seconds remaining: " + (millisUnitFinished / 1000) + 1,
//                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {
//                if (mInterstitialAd.isLoaded()){
//                    mInterstitialAd.show();
//                }
                prefs.setFirstRun(false);
                //Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
            }
        };
    }

    private void showInterestialAd() {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(ADMOB_INTERESTIAL_CODE);
        loadInterestilaAdd();
    }

    private void loadInterestilaAdd() {
        mInterstitialAd.loadAd(new AdRequest
                .Builder()
                //.addTestDevice("ABA9235A80AA27B927851A9936184A80")
                .build());
    }

    private void initilizeBanerAdd() {
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest
                .Builder()
                //.addTestDevice("ABA9235A80AA27B927851A9936184A80")
                .build();
        mAdView.loadAd(adRequest);
    }

    private void intilizeAdmobAd() {
        MobileAds.initialize(this, ADMOB_APP_ID);
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
            case R.id.nav_all_ascii_code:
                this.NavigationviewId = id;
                changeFragment(ASCII_TITLE, new AsciiCodesFM()); break;
            case R.id.nav_bcd_code:
                this.NavigationviewId = id;
                changeFragment(BCD_TITLE, new BcdCodesFM()); break;
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
        if (mInterstitialAd.isLoaded() && !prefs.isFirstRun()){
            mInterstitialAd.show();
            prefs.setFirstRun(true);
        }
        toolbar.setTitle(tolbarTitle);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_Container,fragment);
        //transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    public int getNavigationViewId() {
        return this.NavigationviewId;
    }
}
