package com.example.marwabengamraapp.data;



import com.example.marwabengamraapp.Model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    public final String BASE_URL = "http://178.128.198.168:3001/";
    
    PostInterface postInterface;
    private static PostsClient INSTANCE;
    
    public PostsClient() {
        
        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }
    
    
    public static PostsClient getINSTANCE() {
        
        if (INSTANCE == null) {
            return new PostsClient();
        }
        return INSTANCE;
    }
    
    
    public Call<List<PostModel>> getPosts(){
        return postInterface.getPosts("Bearer 37fe387a1e92a18c8ebfed8b1c7ea8c84a49ff4fba76946bcf1fe43760cd2a0b");
    }
    
    
    
    
}
