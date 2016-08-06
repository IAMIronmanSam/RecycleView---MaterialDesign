package com.seattle.arivu.recycleviewdemo.s.util;

import com.seattle.arivu.recycleviewdemo.s.adpaters.MoviesAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v-arambi on 8/5/2016.
 */
public class movieData {
    private List<movieList> movieItem = new ArrayList<>();
    private MoviesAdapter mAdapter;
    public void prepareMovieData() {
        movieList movie = new movieList("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieItem.add(movie);

        movie = new movieList("Inside Out", "Animation, Kids & Family", "2015");
        movieItem.add(movie);

        movie = new movieList("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieItem.add(movie);

        movie = new movieList("Shaun the Sheep", "Animation", "2015");
        movieItem.add(movie);

        movie = new movieList("The Martian", "Science Fiction & Fantasy", "2015");
        movieItem.add(movie);

        movie = new movieList("Mission: Impossible Rogue Nation", "Action", "2015");
        movieItem.add(movie);

        movie = new movieList("Up", "Animation", "2009");
        movieItem.add(movie);

        movie = new movieList("Star Trek", "Science Fiction", "2009");
        movieItem.add(movie);

        movie = new movieList("The LEGO Movie", "Animation", "2014");
        movieItem.add(movie);

        movie = new movieList("Iron Man", "Action & Adventure", "2008");
        movieItem.add(movie);

        movie = new movieList("Aliens", "Science Fiction", "1986");
        movieItem.add(movie);

        movie = new movieList("Chicken Run", "Animation", "2000");
        movieItem.add(movie);

        movie = new movieList("Back to the Future", "Science Fiction", "1985");
        movieItem.add(movie);

        movie = new movieList("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieItem.add(movie);

        movie = new movieList("Goldfinger", "Action & Adventure", "1965");
        movieItem.add(movie);

        movie = new movieList("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieItem.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}
