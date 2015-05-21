package com.example.maxik.myauth.Services;

import com.example.maxik.myauth.Interceptor.UserAgentIntercepter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by maxik on 5/20/15.
 */

@Module
public class RestClientModule {

    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    public RequestInterceptor provideUserAgent() {
        return new UserAgentIntercepter();
    }

    @Provides
    @Singleton
    public RestAdapter provideRestAdapter() {
        Gson gson = new GsonBuilder().create();

        return new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .setConverter(new GsonConverter(gson))
                .setRequestInterceptor(new UserAgentIntercepter())
                .build();
    }

}
