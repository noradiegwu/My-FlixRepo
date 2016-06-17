package com.example.noradiegwu.flixster;

//import android.graphics.Movie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MoviesActivity extends AppCompatActivity {

    ArrayList<Movie> movies;
    MoviesAdapter adapter;
    ListView lvMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        movies = new ArrayList<Movie>();
        adapter = new MoviesAdapter(this, movies);
        lvMovies = (ListView)findViewById(R.id.lvMovies);

        if(lvMovies != null) {
            lvMovies.setAdapter(adapter);
        }

        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // get movie at this position
                Movie moviePos = movies.get(position);
                // Make an Intent
                Intent iDetails = new Intent(MoviesActivity.this, MovieDetailsActivity.class);
                // bundle "extras" for delivery to second activity
                iDetails.putExtra("title", moviePos.getTitle());
                iDetails.putExtra("synopsis", moviePos.getOverview());
                iDetails.putExtra("imagePortrait", moviePos.getPosterUrl());
                iDetails.putExtra("imageLand", moviePos.getBackdropImg());
                iDetails.putExtra("rating", moviePos.getRating());
                iDetails.putExtra("release", moviePos.getRelease());
                iDetails.putExtra("popularity", moviePos.getPopularity());
                // bring up the activity
                startActivity(iDetails);
            }

        });

        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";

        AsyncHttpClient client = new AsyncHttpClient();

        client.get(url, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                JSONArray movieJsonResults = null;

                try {
                    // 1. Get the movies
                    movieJsonResults = response.getJSONArray("results");
                    movies.addAll(Movie.fromJSONArray(movieJsonResults));
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });


    }
}
