package com.example.marwabengamraapp.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.marwabengamraapp.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        Intent i = getIntent();
        String image_Uri = i.getStringExtra("URL");
        String name = i.getStringExtra("NAME");
        String desc = i.getStringExtra("DESC");

        ImageView image = findViewById(R.id.imageView);
        TextView descTV = findViewById(R.id.textView_desc);
        TextView nameTV = findViewById(R.id.textview_name);


        nameTV.setText(name);
        descTV.setText(desc);

        Picasso.get().load(image_Uri).fit().centerInside().into(image);



    }


}
