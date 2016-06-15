package com.example.noradiegwu.flixster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MoviesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        // 1. Get the movies
        ArrayList<Movie> movies = Movie.getFakeMovies();

        // 2. Get the list view that we want to populate
        ListView lvMovies = (ListView)findViewById(R.id.lvMovies);

        // 3. Create an array adapter
        // takes the adapter and maps it to the view so that it shows up
        //ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(this, android.R.layout.simple_list_item_1, movies);
        MoviesAdapter adapter = new MoviesAdapter(this, movies);
        // 4. Associate the adapter with the list view
        if(lvMovies != null) {
            lvMovies.setAdapter(adapter);
        }

    }
}
