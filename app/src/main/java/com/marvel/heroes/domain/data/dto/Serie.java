package com.marvel.heroes.domain.data.dto;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sergio on 19/06/16.
 */

public class Serie implements Parcelable{

    public String resourceURI;

    public String name;

    protected Serie(Parcel in) {
        resourceURI = in.readString();
        name = in.readString();
    }

    public static final Creator<Serie> CREATOR = new Creator<Serie>() {
        @Override
        public Serie createFromParcel(Parcel in) {
            return new Serie(in);
        }

        @Override
        public Serie[] newArray(int size) {
            return new Serie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(resourceURI);
        dest.writeString(name);
    }
}
