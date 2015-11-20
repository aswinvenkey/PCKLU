package com.racingwheels.aswinvenkat.pcklu;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;

import com.bakar.api.service.BakarService;
import com.bakar.bean.Campus;
import com.bakar.utils.LocalStoreUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.io.IOException;

/**
 * Created by gauravarora on 11/05/15.
 */
public class PushNotificationUtils {

    private static final String SENDER_ID = "852834533424";

    public static void registerForPushNotification(Context context) {
        String userId = getUserId(context);
        if(TextUtils.isEmpty(userId)){
            return;
        }

        String registrationId = getRegistrationId(context);
        if(!TextUtils.isEmpty(registrationId)){
            return;
        }

        PushNotificationRegistrar pushNotificationRegistrar = new PushNotificationRegistrar(context);
        pushNotificationRegistrar.execute();
    }

    private static String getRegistrationId(Context context){
        return LocalStoreUtil.getRegistrationId(context);
    }

    private static String getUserId(Context context){

        return null;
    }

    private static class PushNotificationRegistrar extends AsyncTask<Void, Void, Void> {

        private Context context;

        private PushNotificationRegistrar(Context context){
            this.context = context;
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(context);
                if (gcm == null) {
                    gcm = GoogleCloudMessaging.getInstance(context);
                }
                String registrationId = gcm.register(SENDER_ID);
                LocalStoreUtil.saveRegistrationId(registrationId, context);
                new BakarService().registerForPushNotification(getUserId(context), registrationId, null);
            } catch (IOException ex) {
            }
            return null;
        }

    }


}
