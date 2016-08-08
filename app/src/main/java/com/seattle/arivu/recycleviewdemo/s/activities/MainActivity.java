package com.seattle.arivu.recycleviewdemo.s.activities;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.seattle.arivu.recycleviewdemo.R;
import com.seattle.arivu.recycleviewdemo.s.adpaters.DividerItemDecoration;
import com.seattle.arivu.recycleviewdemo.s.adpaters.MoviesAdapter;
import com.seattle.arivu.recycleviewdemo.s.util.movieData;
import com.seattle.arivu.recycleviewdemo.s.util.movieList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    private List<movieList> movieItem = new ArrayList<>();
    private movieData mveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        movieAdapterInit();
        prepareMovieData();
    }

    public void movieAdapterInit() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new MoviesAdapter(movieItem);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                movieList movie = movieItem.get(position);
                Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    public void prepareMovieData() {
        //Need to change as JSON from service
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

    /*Item Click Listener*/
    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private MainActivity.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final MainActivity.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

}