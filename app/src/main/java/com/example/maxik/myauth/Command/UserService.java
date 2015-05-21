package com.example.maxik.myauth.Command;

import com.example.maxik.myauth.Entity.User;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.Path;

/**
 * Created by maxik on 5/19/15.
 */
public interface UserService {

    @GET("/user")
    public void authenticate(@Header("Authorization") String authorization, Callback<User> callback);

    @GET("/users/{name}/repos")
    public void findAll(@Path("name") String name, Callback<List<User>> callback);

}
