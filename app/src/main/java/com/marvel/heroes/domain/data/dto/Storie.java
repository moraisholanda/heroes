package com.marvel.heroes.domain.data.dto;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by sergio on 19/06/16.
 */

public class Storie implements Parcelable {



    public String collectionURI;

    public List<Items> items;

    public Integer returned;

    public Integer available;

    protected Storie(Parcel in) {
        collectionURI = in.readString();
    }

    public static final Creator<Storie> CREATOR = new Creator<Storie>() {
        @Override
        public Storie createFromParcel(Parcel in) {
            return new Storie(in);
        }

        @Override
        public Storie[] newArray(int size) {
            return new Storie[size];
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
