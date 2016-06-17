package com.example.noradiegwu.flixster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        // back/up arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        // grab the title from the "extra" bundle (from main activity) and set the text in new activity
        String title = getIntent().getStringExtra("title");
        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText(title);

        // synopsis
        String synopsis = getIntent().getStringExtra("synopsis");
        TextView tvOverview = (TextView) findViewById(R.id.tvOverview);
        tvOverview.setText(synopsis);

        // release date
        String release = getIntent().getStringExtra("release");
        TextView tvReleaseDate = (TextView) findViewById(R.id.tvReleaseDate);
        tvReleaseDate.setText("Release Date: " + release);

        // image
        String backdrop = getIntent().getStringExtra("imageLand");
        Picasso.with(this).load(backdrop).placeholder(R.drawable.stock_photo_land).into((ImageView)findViewById(R.id.ivPoster));

        // rating
        int rating = getIntent().getIntExtra("rating", 0);
        RatingBar ratingBar = (RatingBar)findViewById(R.id.rbRating);
        ratingBar.setRating(rating/2);
        ratingBar.setFocusable(false);
    }
}
