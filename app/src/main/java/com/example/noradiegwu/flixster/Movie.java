package com.example.noradiegwu.flixster;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Movie {
    public String posterUrl;
    public String overview;
    public int rating;
    public String title;
    public String backdropImg;
    public int popularity;
    public String release;


    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterUrl = jsonObject.getString("poster_path");
        this.title = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.rating = jsonObject.getInt("vote_average");
        this.backdropImg = jsonObject.getString("backdrop_path");
        this.popularity = jsonObject.getInt("popularity");
        this.release = jsonObject.getString("release_date");

    }

    public String getRelease() {
        return release;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getBackdropImg() {
        return String.format("https://image.tmdb.org/t/p/w342%s", backdropImg);
    }


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

    public static ArrayList<Movie> fromJSONArray(JSONArray array) {
        ArrayList<Movie> results = new ArrayList<>();

        for(int i = 0; i < array.length(); i++) {
            try {
                results.add(new Movie(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

}
