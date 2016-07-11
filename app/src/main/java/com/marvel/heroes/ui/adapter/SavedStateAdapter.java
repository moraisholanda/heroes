package com.marvel.heroes.ui.adapter;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sergio on 11/07/16.
 */
public class SavedStateAdapter<T extends Parcelable> implements Parcelable {

    private final T[] items;
    private String savedComics;

    public SavedStateAdapter(Parcel parcel) {
        this.items = (T[]) parcel.readParcelableArray(ClassLoader.getSystemClassLoader());
    }

    public SavedStateAdapter(String savedComics, T[] items) {
        this.savedComics = savedComics;
        this.items = items;
    }

    public T[] getItems() {
        return items;
    }

    public String getSavedComics() {
        return savedComics;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(savedComics);
        dest.writeParcelableArray(items, 0);
    }

    public static final Creator<SavedStateAdapter> CREATOR = new Creator<SavedStateAdapter>() {
        @Override
        public SavedStateAdapter createFromParcel(Parcel in) {
            return new SavedStateAdapter(in);
        }

        @Override
        public SavedStateAdapter[] newArray(int size) {
            return new SavedStateAdapter[size];
        }
    };

}
