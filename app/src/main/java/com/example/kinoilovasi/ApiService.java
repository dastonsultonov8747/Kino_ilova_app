package com.example.kinoilovasi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("kinolar")
    Call<List<Kino>> getKinolar();

}
