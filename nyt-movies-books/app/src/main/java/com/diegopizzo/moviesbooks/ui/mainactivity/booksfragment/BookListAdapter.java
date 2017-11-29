package com.diegopizzo.moviesbooks.ui.mainactivity.booksfragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.bumptech.glide.Glide;
import com.diegopizzo.moviesbooks.R;
import com.diegopizzo.moviesbooks.business.network.model.books.Book;

import java.util.List;

/**
 * Created by diegopizzo on 25/11/2017.
 */

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> {

    // Store the context for easy access
    private final Context mContext;
    // Store a member variable for the items
    private List<Book> bookList;

    public BookListAdapter(final Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final Context context = parent.getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the custom layout
        final View bookItemView = inflater.inflate(R.layout.book_item_layout, parent, false);

        // Return a new holder instance
        return new ViewHolder(bookItemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Book book = bookList.get(position);
        Glide.with(mContext).load(book.getBookImage()).into(holder.imageBook);
        holder.ratingBar.setRating(book.getRank());
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public void swapItems(final List<Book> list) {
        if (list != null && bookList != list) {
            bookList = list;
            notifyDataSetChanged();
        }
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageBook;
        RatingBar ratingBar;

        public ViewHolder(final View itemView) {
            super(itemView);
            imageBook = (ImageView) itemView.findViewById(R.id.bookImageView);
            ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBarBooks);
        }
    }

}
