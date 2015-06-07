package com.example.maxik.myauth.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.maxik.myauth.Command.UserService;
import com.example.maxik.myauth.Entity.Repo;
import com.example.maxik.myauth.Entity.User;
import com.example.maxik.myauth.ListAdapter.RepoAdapter;
import com.example.maxik.myauth.R;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends SignInAbstractActivity {

    private User user;
    private RestAdapter adapter;

    /**
     * Create new main activity intent.
     * @param context
     * @return
     */
    public static final Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = getUser();
        adapter = getRestAdapter();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        final ListView listView = (ListView) findViewById(R.id.listView);

        adapter.create(UserService.class).findMyRepos(user.getLogin(), new Callback<List<Repo>>() {
            @Override
            public void success(List<Repo> repos, Response response) {
                RepoAdapter adapter = new RepoAdapter(MainActivity.this, repos);
                listView.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
