package com.example.myapplication;

import android.app.Application;
import android.os.Bundle;

import com.onesignal.Continue;
import com.onesignal.OneSignal;
import com.onesignal.debug.LogLevel;

public class application extends Application {

        private static final String ONESIGNAL_APP_ID = "71d0cb64-b2be-41b0-a6eb-e3785fbbd4e4";


        @Override
        public void onCreate() {
                super.onCreate();
                // OneSignal Initialization
                OneSignal.initWithContext(this, ONESIGNAL_APP_ID);

        } // `requestPermission` completed successfully and the user has accepted permiss
}
