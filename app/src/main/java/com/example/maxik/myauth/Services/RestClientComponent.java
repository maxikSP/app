package com.example.maxik.myauth.Services;

import javax.inject.Singleton;

import dagger.Component;
import retrofit.RestAdapter;

/**
 * Created by maxik on 5/20/15.
 */

@Singleton
@Component(modules = {RestClientModule.class})
public interface RestClientComponent {

    public RestAdapter provideRestAdapter();

}
