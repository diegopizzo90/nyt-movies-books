package com.diegopizzo.moviesbooks.ui.booksfragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.diegopizzo.moviesbooks.R;
import com.diegopizzo.moviesbooks.business.network.model.books.ListResults;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diegopizzo on 25/11/2017.
 */

public class BestSellerListAdapter extends RecyclerView.Adapter<BestSellerListAdapter.ViewHolder> {

    // Store a member variable for the items
    private List<ListResults> bestSellerList;


    public BestSellerListAdapter() {
        bestSellerList = new ArrayList<>();
    }

    @Override
    public BestSellerListAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {

        final Context context = parent.getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the custom layout
        final View bestSellerItemView = inflater.inflate(R.layout.bestseller_item_layout, parent, false);

        // Return a new holder instance
        return new ViewHolder(bestSellerItemView);
    }

    @Override
    public void onBindViewHolder(final BestSellerListAdapter.ViewHolder holder, final int position) {
        final ListResults bestSeller = bestSellerList.get(position);
        // Set item views based on your views and data model
        holder.bestSellerTitle.setText(bestSeller.getDisplayName());
        holder.bookListAdapter.swapItems(bestSeller.getBooks());
    }

    @Override
    public int getItemCount() {
        return bestSellerList.size();
    }

    public void swapItems(final List<ListResults> list) {
        if (list != bestSellerList) {
            bestSellerList = list;
            notifyDataSetChanged();
        }
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {

        BookListAdapter bookListAdapter;
        TextView bestSellerTitle;
        RecyclerView bookRecyclerView;

        public ViewHolder(final View itemView) {
            super(itemView);
            bestSellerTitle = (TextView) itemView.findViewById(R.id.bestSellerTitleTextView);
            final Context context = itemView.getContext();
            bookRecyclerView = (RecyclerView) itemView.findViewById(R.id.booksRecyclerView);
            bookRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            final SnapHelper snapHelperStart = new GravitySnapHelper(Gravity.START);
            snapHelperStart.attachToRecyclerView(bookRecyclerView);
            bookListAdapter = new BookListAdapter(context);
            bookRecyclerView.setAdapter(bookListAdapter);
        }
    }
}
