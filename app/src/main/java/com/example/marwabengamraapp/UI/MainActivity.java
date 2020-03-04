package com.example.marwabengamraapp.UI;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marwabengamraapp.Model.PostModel;
import com.example.marwabengamraapp.R;
import com.example.marwabengamraapp.data.OnItemClickListener;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    PostViewModel postViewModel;
    PostAdapter postsAdapter = new PostAdapter();
    private String EXTRA_ID = "ID";

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

        intent.putExtra(EXTRA_ID, currentItem.getApp_id());
        startActivity(intent);
    }
}
