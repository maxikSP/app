package com.example.maxik.myauth.Command;

import com.example.maxik.myauth.Entity.User;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;

/**
 * Created by maxik on 5/19/15.
 */
public interface UserService {

    @GET("/users/{id}")
    public User findUser(@Path("id") int id);

    @GET("/users/{email}")
    public User findUser(@Path("email") String email);

    @Headers("User-Agent: Retrofit-Sample-App")
    @GET("/users/{name}/repos")
    public void findAll(@Path("name") String name, Callback<List<User>> callback);

}
