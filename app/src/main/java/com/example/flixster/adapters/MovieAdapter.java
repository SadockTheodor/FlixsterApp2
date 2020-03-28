package com.example.flixster.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Parcel;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flixster.DetailActivity;
import com.example.flixster.R;
import com.example.flixster.models.movie;

import org.parceler.Parcels;

import java.util.List;

public class MovieAdapter extends  RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    Context context;
     List<movie> movies;

    public MovieAdapter(Context context, List<movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    // Usually involves inflating a layout from xml and returning the holder


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("MovieAdapter", "OncreateViewHolder");
       View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(movieView);
    }
    //  Involve populating data into the item through holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("MovieAdapter", "OncreateViewHolder"+ position);
        // Get the movie at the passed in position.
        movie movie = movies.get(position);
        // Bind the movie data into the VH
        holder.bind (movie);

    }
    //Returning the total item of the list
    @Override
    public int getItemCount() {
        return  movies.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvOverview;
        ImageView ivPoster;
        RelativeLayout container;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            ivPoster = itemView.findViewById(R.id.ivPoster);
            container = itemView.findViewById(R.id.container);
        }

        public void bind(final movie movie) {
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverView());
            String imageUrl;
            //if phone is on landscape
            if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                //then imageUrl = back drop image
                imageUrl = movie.getBackdrop_path();
            }
           else {
                // else imageUrl = poster image
                imageUrl = movie.getPosterPath();
            }
            Glide.with(context).load(imageUrl).into(ivPoster);

           //1- Register ClickListener in whole row
            container.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent i = new Intent(context, DetailActivity.class);
                   i.putExtra("title",movie.getTitle());
                   i.putExtra("movie", Parcels.wrap(movie));
                   context.startActivity(i);

               }
           });

        }
    }
}
