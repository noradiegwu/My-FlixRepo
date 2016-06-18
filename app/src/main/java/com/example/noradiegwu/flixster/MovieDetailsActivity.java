package com.example.noradiegwu.flixster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class MovieDetailsActivity extends AppCompatActivity {

    @BindView(R.id.tvOverview) TextView tvOverview;
    @BindView(R.id.tvTitle) TextView tvTitle;
    @BindView(R.id.tvReleaseDate) TextView tvReleaseDate;
    @BindView(R.id.rbRating) RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        ButterKnife.bind(this);
        // back/up arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        // grab the title from the "extra" bundle (from main activity) and set the text in new activity
        String title = getIntent().getStringExtra("title");
        tvTitle.setText(title);

        // synopsis
        String synopsis = getIntent().getStringExtra("synopsis");
        tvOverview.setText(synopsis);

        // release date
        String release = getIntent().getStringExtra("release");
        tvReleaseDate.setText("Release Date: " + release);

        // image
        String backdrop = getIntent().getStringExtra("imageLand");
        Picasso.with(this).load(backdrop).transform(new RoundedCornersTransformation(10, 10)).transform(new RoundedCornersTransformation(10, 10)).placeholder(R.drawable.stock_photo_land).into((ImageView)findViewById(R.id.ivPoster));

        // rating
        float rating = ((float) getIntent().getFloatExtra("rating", (float) 0));
        ratingBar.setRating(rating/2);
        ratingBar.setFocusable(false);
    }
}
