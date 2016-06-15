package com.example.noradiegwu.flixster;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

//import android.graphics.Movie;

/**
 * Created by noradiegwu on 6/15/16.
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {

    public MoviesAdapter(Context context, List<Movie> movies) {
        super(context, R.layout.item_movie, movies);
    } // ???

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

         // Get the data item for this position
        Movie movie = getItem(position);


        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);
        }


        // Lookup text(title) view for data population
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        //Lookup overview view
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        //find image view
        ImageView ivPoster = (ImageView) convertView.findViewById(R.id.ivPoster);
        // clear out image from convertView
        ivPoster.setImageResource(0);


        // Populate the data into the template view using the data object
        tvTitle.setText(movie.getTitle());
        tvOverview.setText(movie.getOverview());
        //ivPoster.setImageResource(movie.getPosterUrl());



        Log.d("MoviesAdapter", "Position: " + position);

        //ivPoster.set
        String imageUri = "https://i.imgur.com/tGbaZCY.jpg";
        Picasso.with(getContext()).load(movie.getPosterUrl()).into(ivPoster);

        // Return the completed view to render on screen
        return convertView;


    }
}
