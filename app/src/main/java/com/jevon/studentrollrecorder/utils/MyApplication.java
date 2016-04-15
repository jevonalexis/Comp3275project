package com.jevon.studentrollrecorder.utils;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;

import com.firebase.client.Firebase;

/**
 * Created by jevon on 11-Apr-16.
 */

//Extending the Application class allows us to store fields and methods accessible to all activities and classes
public class MyApplication extends Application {
    private static MyApplication mApplication;
    private Firebase ref;

    public static MyApplication getInstance(){
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }

    public void setFireBaseRef(String url){
        this.ref = new Firebase(url);
    }

    public Firebase getRef(){
        return this.ref;
    }

    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

}