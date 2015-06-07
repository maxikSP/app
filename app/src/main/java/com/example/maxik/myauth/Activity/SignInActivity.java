package com.example.maxik.myauth.Activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.maxik.myauth.Fragment.SignIn;
import com.example.maxik.myauth.R;

public class SignInActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getFragmentManager()
                .beginTransaction()
                .add(R.id.sign_in_activity, new SignIn())
                .commit();
    }

}
