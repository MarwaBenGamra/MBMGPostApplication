package com.example.marwabengamraapp.data;

import com.example.marwabengamraapp.Model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;


public interface PostInterface {

    @GET("api/v1/apps?category_id=1&page_number=0&page_size=50")
    public Call<List<PostModel>> getPosts(@Header("Authorization") String auth);


    @GET("api/v1/apps/{app_id}")
    public Call<PostModel> getPostDetail(@Path("app_id") String id, @Header("Authorization") String auth);
}
