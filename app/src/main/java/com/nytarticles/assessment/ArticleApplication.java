package com.nytarticles.assessment;

import android.app.Application;

import timber.log.Timber;

public class ArticleApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
    }
}
