package edu.gsu.student.csc4360;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PrefManager {

    public static void loadPreferences( Context context ) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        if (prefs.getBoolean("orange_theme", true)) {
            context.setTheme(R.style.LightTheme);
        } else {
            context.setTheme(R.style.AppTheme);
        }
    }
}
