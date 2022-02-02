package com.bignerdranch.android.javamvvmexample2.retrofit;

import android.app.Application;

import com.bignerdranch.android.javamvvmexample2.R;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitUtility extends Application {

    final String TAG = getClass().getSimpleName();
    private static RetrofitUtility mInstance;
    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://date.nager.at/api/v3/";

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized RetrofitUtility getmInstance() {
        return mInstance;
    }

    public static Retrofit getRetrofitClient() {
        if(retrofit == null) {
            okhttp3.OkHttpClient client = new okhttp3.OkHttpClient.Builder().build();

            retrofit = new Retrofit.Builder()
                    .client(client)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }

        return retrofit;
    }
}
