package com.example.noradiegwu.flixster;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

//import android.graphics.Movie;

public class MoviesAdapter extends ArrayAdapter<Movie> {

    private static class ViewHolder {
        TextView tvTitle;
        TextView tvOverview;
        //TextView tvRating;
        ImageView ivPoster;


    }


    public MoviesAdapter(Context context, List<Movie> movies) {
        super(context, R.layout.item_movie, movies);
    } // ???

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

         // Get the data item for this position
        Movie movie = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);
            viewHolder.ivPoster = (ImageView) convertView.findViewById(R.id.ivPoster);
            convertView.setTag(viewHolder);

        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.tvTitle.setText(movie.title);
        viewHolder.tvOverview.setText(movie.overview);

        // populate images
        // check for orientation
        int orientation = getContext().getResources().getConfiguration().orientation;
        // if portrait, use poster
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            //Picasso.with(getContext()).load(movie.getPosterUrl()).into(viewHolder.ivPoster);
            Picasso.with(getContext()).load(movie.getPosterUrl()).transform(new RoundedCornersTransformation(10, 10)).placeholder(R.drawable.stock_photo_portrait).into(viewHolder.ivPoster);

            // else if landscape, use backdrop
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //Picasso.with(getContext()).load(movie.getBackdropImg()).into(viewHolder.ivPoster);        // Return the completed view to render on screen
            Picasso.with(getContext()).load(movie.getBackdropImg()).transform(new RoundedCornersTransformation(10, 10)).placeholder(R.drawable.stock_photo_land).into(viewHolder.ivPoster);        // Return the completed view to render on screen

        }

        return convertView;


    }


    }

