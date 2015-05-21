package com.example.maxik.myauth.Listener;

import android.content.Context;
import android.content.res.Resources;
import android.util.Base64;
import android.view.View;

import com.example.maxik.myauth.Command.UserService;
import com.example.maxik.myauth.Entity.User;
import com.example.maxik.myauth.R;
import com.example.maxik.myauth.Services.DaggerRestClientComponent;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by maxik on 5/19/15.
 */
public class OnSignInButtonClick implements View.OnClickListener {

    private Context activity;

    public OnSignInButtonClick(Context activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {

        RestAdapter adapter = DaggerRestClientComponent.create().provideRestAdapter();

        String username = this.activity.getString(R.string.github_username);
        String password = this.activity.getString(R.string.github_password);

        byte[] bytes = String.format("%s:%s", username, password).getBytes();
        String encodedCredentials = Base64.encodeToString(bytes, Base64.URL_SAFE);

        adapter.create(UserService.class).authenticate(encodedCredentials, new Callback<User>() {
            @Override
            public void success(User user, Response response) {
                int a = 2;
            }

            @Override
            public void failure(RetrofitError error) {
                int a = 2;
            }
        });

    }
}
