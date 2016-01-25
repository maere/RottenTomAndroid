package com.example.msssd.rottentomandro;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by msssd on 1/23/16.
 */

public class BoxOfficeMovie {
    public String title;
    public String posterURL;
    public float criticScore;

    public BoxOfficeMovie(){

    }

    public BoxOfficeMovie(String title, String posterURL, float criticScore){
        this.title = title;
        this.posterURL = posterURL;
        this.criticScore = criticScore;
    }


    public String getScore(){
        return String.valueOf(criticScore) + "%";
    }

//before we get to networking, we put a tester helper to make sure our object handshake is working

    public static ArrayList<BoxOfficeMovie> getFakeMovies(){
        ArrayList<BoxOfficeMovie> movies = new ArrayList<>();

        movies.add(new BoxOfficeMovie("Mission: Impossible", "http://bit.ly/1eWVWvz", 93.0f));
        movies.add(new BoxOfficeMovie("Ant-Man", "http://bit.ly/1NdWEjS", 80.0f));
        movies.add(new BoxOfficeMovie("Minions", "http://bit.ly/1J0HaSF", 54.0f));

        return movies;
    }




    public static BoxOfficeMovie fromJson(JSONObject jsonObject){
        BoxOfficeMovie boxOfficeMovie = new BoxOfficeMovie();

        try{
            boxOfficeMovie.title = jsonObject.getString("title");
            boxOfficeMovie.posterURL = jsonObject.getJSONObject("posters").getString("thumbnail");
            boxOfficeMovie.criticScore = jsonObject.getJSONObject("ratings").getInt("critics_score");

        }catch(JSONException e){
            e.printStackTrace();
            return null;
        }
        return boxOfficeMovie;
    }


    public static ArrayList<BoxOfficeMovie> fromJson(JSONArray jsonArray){
        ArrayList<BoxOfficeMovie> movies = new ArrayList<>(jsonArray.length());
        for(int i=0; i< jsonArray.length(); i++){

            JSONObject movieJson = null;

            try{
                movieJson = jsonArray.getJSONObject(i);
            }
            catch(Exception e){
                e.printStackTrace();;
                continue;
            }

            BoxOfficeMovie movie = BoxOfficeMovie.fromJson(movieJson);
            if(movie !=null){
               movies.add(movie);
            }

        }
        return movies;
    }



}
//In order to see images will need to give app permissions to access internet...this is done in the manifest.xml file
// <uses-permission android:name="android.permission.INTERNET" />