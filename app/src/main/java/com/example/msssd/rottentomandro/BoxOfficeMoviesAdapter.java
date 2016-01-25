package com.example.msssd.rottentomandro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by msssd on 1/23/16.
 */
public class BoxOfficeMoviesAdapter extends ArrayAdapter<BoxOfficeMovie> {

    public BoxOfficeMoviesAdapter(Context context, ArrayList<BoxOfficeMovie> movies){

        super(context, 0, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        BoxOfficeMovie movie = getItem(position);

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_box_office_movie, parent, false);
        }

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvMovieTitle);
        TextView tvCriticScore = (TextView) convertView.findViewById(R.id.tvCriticsScore);
        ImageView ivPosterImage = (ImageView) convertView.findViewById(R.id.lvPosterImage);


        tvTitle.setText(movie.title);
        tvCriticScore.setText(movie.getScore());
        Picasso.with(getContext()).load(movie.posterURL).into(ivPosterImage);

        return convertView;


    }
}
