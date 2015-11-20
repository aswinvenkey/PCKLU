package com.racingwheels.aswinvenkat.pcklu;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by gauravarora on 04/05/15.
 */
public class LocalStoreUtil {

    public static final String PREF_FILE_NAME = "com.bakar";



    public static void saveRegistrationId(String registrationId, Context context) {
        try {
            SharedPreferences.Editor editor = getSharedEditor(context);
            editor.putString("registrationId", registrationId);
            editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getRegistrationId(Context context) {
        try {
            SharedPreferences pref = getSharedPreference(context);
            return pref.getString("registrationId", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static SharedPreferences.Editor getSharedEditor(Context context)
            throws Exception {
        if (context == null) {
            throw new Exception("Context null Exception");
        }
        return getSharedPreference(context).edit();
    }

    private static SharedPreferences getSharedPreference(Context context)
            throws Exception {
        if (context == null) {
            throw new Exception("Context null Exception");
        }
        return context.getSharedPreferences(PREF_FILE_NAME, 0);
    }

}
