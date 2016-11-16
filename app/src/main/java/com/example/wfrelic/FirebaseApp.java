package com.example.wfrelic;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by hackeru on 16/11/2016.
 */
public class FirebaseApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /* Enable disk persistence  */
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
