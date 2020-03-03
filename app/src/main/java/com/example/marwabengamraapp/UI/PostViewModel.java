package com.example.marwabengamraapp.UI;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.marwabengamraapp.Model.PostModel;
import com.example.marwabengamraapp.data.PostsClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/***
 * Created by Marwa Ben Gamra on 02/03/2020.
 */
public class PostViewModel extends ViewModel {

    MutableLiveData<List<PostModel>> postsMutuableLiveData = new MutableLiveData<>();

    public void getPosts(){

        PostsClient.getINSTANCE().getPosts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {

              // add result to mutuableData
                postsMutuableLiveData.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Log.e("msg",t.getMessage());
            }
        });
    }
    
}
