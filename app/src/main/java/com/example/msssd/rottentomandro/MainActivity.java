package com.example.msssd.rottentomandro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

;

public class MainActivity extends AppCompatActivity {

    ListView lvMovies;
    BoxOfficeMoviesAdapter adapterMovies;
    RottenTomClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovies = (ListView) findViewById(R.id.lvMovies);
        ArrayList<BoxOfficeMovie> aMovies = new ArrayList<>();   //.getFakeMovies();
        adapterMovies = new BoxOfficeMoviesAdapter(this, aMovies);
        lvMovies.setAdapter(adapterMovies);

        fetchBoxOfficeMovies();

    }

    private void fetchBoxOfficeMovies() {
        client = new RottenTomClient();
        client.getBoxOfficeMovies(new JsonHttpResponseHandler(){ //anonymous function -- needed
            //curly brace means JSONObject, straigh [] means JSONarray

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                JSONArray items = null;

                try{
                    items = response.getJSONArray("movies");
                    ArrayList<BoxOfficeMovie> movies = BoxOfficeMovie.fromJson(items);
                    adapterMovies.addAll(movies);
                } catch (JSONException e){
                    e.printStackTrace();
                }
            }

        });

    }


}
