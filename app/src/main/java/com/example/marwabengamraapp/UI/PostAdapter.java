package com.example.marwabengamraapp.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.marwabengamraapp.Model.PostModel;
import com.example.marwabengamraapp.R;
import com.example.marwabengamraapp.data.OnItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<PostModel> mPostList = new ArrayList<>();

    private OnItemClickListener mListener;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mListener = onItemClickListener;
    }
    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_item, parent, false);
        return new PostViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        PostModel currentPost = mPostList.get(position);

        String name = currentPost.getName();
        String shortDescription = currentPost.getShort_desc();
        String url = currentPost.getApp_icon_url();

        holder.mTextviewName.setText(name);
        holder.mTextviewShortDescription.setText(shortDescription);


        //Picasso
        Picasso.get().load(url).into(holder.mImageViewPost);


    }


    @Override
    public int getItemCount() {
        return mPostList.size();
    }

    public void setList(List<PostModel> postModelList) {
        this.mPostList = postModelList;
        notifyDataSetChanged();
    }


    public List<PostModel> getList() {
      return mPostList;
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextviewName;
        public TextView mTextviewShortDescription;
        public ImageView mImageViewPost;

        public PostViewHolder(View itemView) {
            super(itemView);
            mTextviewName = itemView.findViewById(R.id.name_txv);
            mTextviewShortDescription = itemView.findViewById(R.id.short_desc_txv);
            mImageViewPost = itemView.findViewById(R.id.imageView_post);



            //Detail
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClicked(position);
                        }
                    }
                }
            });

        }
    }
}
