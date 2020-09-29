package com.shrimali.logic;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferenceHelper {

    private static SharedPreferences prefs;
    private static SharedPreferences.Editor editor;


    public SharedPreferenceHelper(Context context, String packageName) {
        // get data from shared preferences
        prefs = context.getSharedPreferences(packageName, Context.MODE_PRIVATE);
    }

    public SharedPreferences prefs(){
        return prefs;
    }

    public void set(String key, String value) {
        editor = prefs.edit();
        prefs.edit().putString(key, value).apply();
    }

    public String get(String key, String defaultValue) {
        return prefs.getString(key,defaultValue);
    }

    public Boolean check(String key) {
        return prefs.contains(key);
    }

}

