package com.example.kinoilovasi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static boolean isTester = true;
    public static final String SERVER_DEVELOPMENT = "https://kinoteatr-sayt.onrend" +
            "er.com/api/";
    public static final String SERVER_PRODUCTION = "https://kinoteatr-sayt.onrender.com/api/";

    public static String baseURL() {
        if (isTester) return SERVER_DEVELOPMENT;
        return SERVER_PRODUCTION;
    }
    private static Retrofit retrofit = getRetrofit();

    public static ApiService getApiService = retrofit.create(ApiService.class);

    public static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(baseURL())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}