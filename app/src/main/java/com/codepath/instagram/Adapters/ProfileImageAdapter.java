package com.codepath.instagram.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.instagram.Post;
import com.codepath.instagram.R;
import com.parse.ParseFile;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProfileImageAdapter extends RecyclerView.Adapter<ProfileImageAdapter.Viewholder> {

    private List<Post> posts;
    private Context context;


    public ProfileImageAdapter(List<Post> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post_profile_grid, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ProfileImageAdapter.Viewholder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post, position);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        ImageView ivImageGrid;

        public Viewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            ivImageGrid = itemView.findViewById(R.id.ivImageGrid);
        }

        public void bind(Post post, int position) {
            ParseFile image = post.getImage();
            if (image != null) {
                Glide.with(context).load(image.getUrl()).into(ivImageGrid);
            }
        }
    }

    // Clean all elements of the recycler
    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }

    // Add a list of items
    public void addAll(List<Post> post) {
        posts.addAll(post);
        notifyDataSetChanged();
    }


}
