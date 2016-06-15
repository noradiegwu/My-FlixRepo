package com.example.noradiegwu.flixster;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by noradiegwu on 6/15/16.
 */
public class Movie {
    public String title;

    public int getRating() {
        return rating;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterUrl() {
        return String.format("https://image.tmdb.org/t/p/w342%s", posterUrl);
    }

    public String getTitle() {
        return title;
    }

    public String posterUrl;
    public String overview;
    public int rating;


    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterUrl = jsonObject.getString("poster_path");
        this.title = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.rating = jsonObject.getInt("vote_average");

    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array) {
        ArrayList<Movie> results = new ArrayList<>(); // what are we grabbing here?
        // it is a list of JSONObjects, but what exactly are they?

        for(int i = 0; i < array.length(); i++) {
            try {
                results.add(new Movie(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

   /* public String toString() {
        return title + " - " + rating;
    }*/
}
