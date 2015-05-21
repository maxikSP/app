package com.example.maxik.myauth.Interceptor;

import retrofit.RequestInterceptor;

/**
 * Created by maxik on 5/21/15.
 */
public class UserAgentIntercepter implements RequestInterceptor {

    @Override
    public void intercept(RequestFacade request) {
        request.addHeader("User-Agent", "Dev-App");
    }
}
