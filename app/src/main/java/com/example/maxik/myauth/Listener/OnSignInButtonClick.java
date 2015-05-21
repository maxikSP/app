package com.example.maxik.myauth.Listener;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;

import com.example.maxik.myauth.Command.UserService;
import com.example.maxik.myauth.Entity.RestError;
import com.example.maxik.myauth.Entity.User;
import com.example.maxik.myauth.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

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

        Gson gson = new GsonBuilder().create();
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .setConverter(new GsonConverter(gson))
                .build();

        adapter.create(UserService.class).findAll("octocat", new Callback<List<User>>() {
            @Override
            public void success(List<User> users, Response response) {
                int a = 2;
            }

            @Override
            public void failure(RetrofitError error) {
                int a = 2;
            }
        });




//        AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
//
//        dialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.setTitle("TestTitle");
//        dialog.setMessage("Test message");
//        dialog.create().show();
    }
}
