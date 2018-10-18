package com.ahrasel.numbersystems.Prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.ahrasel.numbersystems.R;

public class AddControllPrefs {
    private final Context context;
    private final SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private boolean isFirstRun;

    public AddControllPrefs(Context context) {
        this.context = context;
        this.preferences = this.context.getSharedPreferences(String.valueOf(R.string.application_settings),
                Context.MODE_PRIVATE);
    }


    public boolean isFirstRun() {
        return preferences.getBoolean("firstrun",false);
    }

    public void setFirstRun(boolean firstRun) {
        editor = preferences.edit();
        editor.putBoolean("firstrun",firstRun);
        editor.apply();
    }
}
