package com.nytarticles.assessment.networking;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.nytarticles.assessment.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;

public class ApiClient {
    private static Retrofit retrofit = null;

    private ApiClient() {
        //To avoid code smell
    }

    public static Retrofit getClient() {
        if (null == retrofit) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            OkHttpClient okHttpClient = builder.build();

            retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}
