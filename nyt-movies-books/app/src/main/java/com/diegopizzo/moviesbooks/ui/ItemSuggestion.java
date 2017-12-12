package com.diegopizzo.moviesbooks.ui;

import android.os.Parcel;

import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;

/**
 * Created by diegopizzo on 11/12/2017.
 */

public class ItemSuggestion implements SearchSuggestion {

    public static final Creator<ItemSuggestion> CREATOR = new Creator<ItemSuggestion>() {
        @Override
        public ItemSuggestion createFromParcel(final Parcel in) {
            return new ItemSuggestion(in);
        }

        @Override
        public ItemSuggestion[] newArray(final int size) {
            return new ItemSuggestion[size];
        }
    };

    private final String itemName;
    private TypeItem typeItem;

    public ItemSuggestion(final String itemName, final TypeItem typeItem) {
        this.itemName = itemName;
        this.typeItem = typeItem;
    }

    public ItemSuggestion(final Parcel source) {
        this.itemName = source.readString();
    }

    public TypeItem getTypeItem() {
        return typeItem;
    }

    @Override
    public String getBody() {
        return itemName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(itemName);
    }

    public enum TypeItem {
        MOVIE,
        BOOK
    }
}
