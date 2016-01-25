package com.example.msssd.rottentomandro;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by msssd on 1/23/16.
 */
public class RottenTomClient {
    private final String API_KEY = "btzqh3hycpqat2qertnf7kts";
    private final String API_BASE_URL = "http://api.rottentomatoes.com/api/public/v1.0/";
    private AsyncHttpClient client;


    public RottenTomClient(){
        this.client = new AsyncHttpClient();
    }

    private String getApiURL(String relativeURL){
            return API_BASE_URL + relativeURL;
    }

    public void getBoxOfficeMovies(JsonHttpResponseHandler handler){
        String url = getApiURL("list/movies/box_office.json");
        RequestParams params = new RequestParams("apikey", API_KEY);
        client.get(url, params, handler);

    }

}
