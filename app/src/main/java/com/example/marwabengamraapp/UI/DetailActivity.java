package com.example.marwabengamraapp.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.marwabengamraapp.Model.PostModel;
import com.example.marwabengamraapp.R;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DetailActivity extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    PostViewModel postViewModel;
    TextView longDescTV;
    TextView nameTV;
    RatingBar ratingBar;
    private List<PostModel.ImageModel> imageModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        Intent i = getIntent();
        String mAppID = i.getStringExtra("ID");

        ratingBar = findViewById(R.id.ratingBar);
        nameTV = findViewById(R.id.textview_name);
        longDescTV = findViewById(R.id.textview_long_desc);


        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);

        postViewModel.getPostDetail(mAppID);

        postViewModel.detailPostMutuableLiveData.observe(this, new Observer<PostModel>() {
            @Override
            public void onChanged(PostModel postModel) {
                longDescTV.setText(postModel.getLong_desc());
                nameTV.setText(postModel.getName());
                ratingBar.setRating(postModel.getTotal_ratings());

                imageModelArrayList = postModel.getApp_images();
                initSlideShow();

            }
        });

    }

    private void initSlideShow() {

        mPager = findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(DetailActivity.this, imageModelArrayList));

        CirclePageIndicator indicator = findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

        //Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES = imageModelArrayList.size();

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }


}
