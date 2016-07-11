package com.marvel.heroes.domain.data.dto;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by sergio on 19/06/16.
 */

public class Event implements Parcelable{

    public String collectionURI;

    public List<Items> items;

    public Integer returned;

    public Integer available;

    protected Event(Parcel in) {
        collectionURI = in.readString();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(collectionURI);
    }
}
