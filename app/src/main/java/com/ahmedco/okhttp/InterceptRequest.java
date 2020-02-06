package com.ahmedco.okhttp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class InterceptRequest implements Interceptor {

    /**
     * URL for the new resource
     */
    private static final String NEW_URL = "https://m.media-amazon.com/images/M/MV5BOTg4ZTNkZmUtMzNlZi00YmFjLTk1MmUtNWQwNTM0YjcyNTNkXkEyXkFqcGdeQXVyNjg2NjQwMDQ@._V1_UX182_CR0,0,182,268_AL_.jpg";

    @Override
    public Response intercept(Chain chain) throws IOException {


        CacheControl cacheControl = new CacheControl.Builder()
        .maxAge(15, TimeUnit.MINUTES)
        // 15 minutes cache
        .build();
        Request.Builder requestBuilder = chain.request().newBuilder();
        // adding a header to the original request
        requestBuilder.removeHeader("Pragma");
        requestBuilder.removeHeader("Cache-Control");
        requestBuilder.addHeader("X-Been","Intercepted");
        // changing the URL
        requestBuilder.url(NEW_URL);
        // returns a response
        return chain.proceed(requestBuilder.build());
    }
}