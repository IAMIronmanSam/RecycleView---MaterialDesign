package com.seattle.arivu.recycleviewdemo.s.adpaters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seattle.arivu.recycleviewdemo.R;
import com.seattle.arivu.recycleviewdemo.s.util.movieList;

import java.util.List;

/**
 * Created by v-arambi on 8/5/2016.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder>{
    private List<movieList> moviesList;
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        movieList movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public MoviesAdapter(List<movieList> moviesList) {
        this.moviesList = moviesList;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.movieTitle);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }
}
