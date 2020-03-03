package com.example.marwabengamraapp.UI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marwabengamraapp.Model.PostModel;
import com.example.marwabengamraapp.R;
import com.example.marwabengamraapp.data.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    PostViewModel postViewModel;
    PostAdapter postsAdapter = new PostAdapter();
    List<PostModel> postModels = new ArrayList<>();
    private String EXTRA_URL_IMAGE = "URL";
    private String EXTRA_NAME = "NAME";
    private String EXTRA_DESC = "DESC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);


        postViewModel.getPosts();

        //RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postsAdapter);


        postViewModel.postsMutuableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                postsAdapter.setList(postModels);

            }
        });

        postsAdapter.setOnItemClickListener(MainActivity.this);

    }


    @Override
    public void onItemClicked(int position) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        PostModel currentItem = postsAdapter.getList().get(position);
        Log.e("cureent pos", ""+currentItem);
        intent.putExtra(EXTRA_URL_IMAGE, currentItem.getApp_icon_url());
        intent.putExtra(EXTRA_NAME, currentItem.getName());
        intent.putExtra(EXTRA_DESC, currentItem.getShort_desc());
        startActivity(intent);
    }
}
