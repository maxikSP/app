package com.example.maxik.myauth.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.maxik.myauth.Entity.User;
import com.example.maxik.myauth.Services.DaggerRestClientComponent;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;

/**
 * Created by maxik on 06.06.15.
 */
public abstract class SignInAbstractActivity extends Activity {

    protected RestAdapter getRestAdapter() {
        return DaggerRestClientComponent.create().provideRestAdapter();
    }

    protected User getUser() {
        SharedPreferences preferences = getSharedPreferences(User.USER_PREFERENCES, Context.MODE_PRIVATE);
        return new GsonBuilder().create().fromJson(preferences.getString(User.USER_PREFERENCES, null), User.class) ;
    }

}
