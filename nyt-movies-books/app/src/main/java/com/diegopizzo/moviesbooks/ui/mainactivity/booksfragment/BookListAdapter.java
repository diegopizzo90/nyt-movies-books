package com.diegopizzo.moviesbooks.ui.mainactivity.booksfragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.diegopizzo.moviesbooks.R;
import com.diegopizzo.moviesbooks.business.network.model.books.Book;
import com.diegopizzo.moviesbooks.ui.itemdetailsactivity.ItemDetailsActivity;

import java.util.List;

/**
 * Created by diegopizzo on 25/11/2017.
 */

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> {

    public static final String BOOK_ISBN_BUNDLE = "bookIsbnBundle";
    public static final String BOOK_LIST_NAME_BUNDLE = "bookListNameBundle";
    public static final String BOOK_IMAGE_BUNDLE = "bookImageBundle";
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
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageBook;
        RatingBar ratingBar;

        public ViewHolder(final View itemView) {
            super(itemView);
            imageBook = (ImageView) itemView.findViewById(R.id.bookImageView);
            ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBarBooks);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(final View v) {
            final int position = getItemCount();
            if (position != RecyclerView.NO_POSITION) {
                final Book book = bookList.get(getLayoutPosition());
                final String isbn = book.getIsbn();
                final String listName = book.getBestSellerTitle();
                final String imageLink = book.getBookImage();

                if (!TextUtils.isEmpty(isbn) && !TextUtils.isEmpty(listName)) {
                    final Context context = v.getContext();
                    final Intent intent = new Intent(context, ItemDetailsActivity.class);
                    final Bundle bookBundle = new Bundle();
                    bookBundle.putString(BOOK_ISBN_BUNDLE, isbn);
                    bookBundle.putString(BOOK_LIST_NAME_BUNDLE, listName);
                    bookBundle.putString(BOOK_IMAGE_BUNDLE, imageLink);
                    intent.putExtras(bookBundle);
                    context.startActivity(intent);
                } else {
                    Toast.makeText(v.getContext(), "Book not exist", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
