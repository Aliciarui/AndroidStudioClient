package com.example.tryproject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    @GET("/")
//    Call<String> fetchContents();
    Call<ResponseBody> getBlog(@Path("id") int id);
}
