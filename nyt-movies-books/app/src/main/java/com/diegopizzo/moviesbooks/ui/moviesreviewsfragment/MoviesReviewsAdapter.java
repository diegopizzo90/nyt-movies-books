package com.diegopizzo.moviesbooks.ui.moviesreviewsfragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.diegopizzo.moviesbooks.R;
import com.diegopizzo.moviesbooks.business.network.model.movies.Multimedia;
import com.diegopizzo.moviesbooks.business.network.model.movies.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diegopizzo on 20/11/2017.
 */

public class MoviesReviewsAdapter extends RecyclerView.Adapter<MoviesReviewsAdapter.ViewHolder> {

    // Store the context for easy access
    private final Context mContext;
    // Store a member variable for the items
    private final List<Result> resultList;

    public MoviesReviewsAdapter(final Context mContext) {
        resultList = new ArrayList<>();
        this.mContext = mContext;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {

        final Context context = parent.getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the custom layout
        final View movieItemView = inflater.inflate(R.layout.movie_review_item, parent, false);

        // Return a new holder instance
        return new ViewHolder(movieItemView);
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // Get the data model based on position
        final Result result = resultList.get(position);
        // Set item views based on your views and data model
        final TextView titleTextView = holder.title;
        titleTextView.setText(result.getDisplayTitle());
        final TextView bylineTextView = holder.byline;
        bylineTextView.setText(result.getByline());
        final TextView headlineTextView = holder.healine;
        headlineTextView.setText(result.getHeadline());
        final ImageView movieImageView = holder.movieImage;
        if (result.getMultimedia() != null) {
            final Multimedia multimedia = result.getMultimedia();
            Glide.with(mContext).load(multimedia.getSrc()).into(movieImageView);
            movieImageView.setMinimumHeight(multimedia.getHeight());
            movieImageView.setMinimumWidth(multimedia.getWidth());
        }
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public void swapItems(final List<Result> results) {
        final int curSize = resultList.size();
        resultList.addAll(results);
        notifyItemRangeChanged(curSize, resultList.size() - 1);
    }

    public void refreshItems(final List<Result> results) {
        resultList.clear();
        resultList.addAll(results);
        notifyDataSetChanged();
    }

    public List<Result> getResultList() {
        return resultList;
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {

        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        TextView title;
        TextView byline;
        TextView healine;
        ImageView movieImage;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(final View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.movieTitleTextView);
            byline = (TextView) itemView.findViewById(R.id.movieBylineTextView);
            healine = (TextView) itemView.findViewById(R.id.movieHeadlineTextView);
            movieImage = (ImageView) itemView.findViewById(R.id.movieImageView);
        }
    }
}
