package com.marvel.heroes.domain.data.dto;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sergio on 20/06/16.
 */

public class Price implements Parcelable {

    public String type;

    public double price;

    protected Price(Parcel in) {
        type = in.readString();
        price = in.readDouble();
    }

    public static final Creator<Price> CREATOR = new Creator<Price>() {
        @Override
        public Price createFromParcel(Parcel in) {
            return new Price(in);
        }

        @Override
        public Price[] newArray(int size) {
            return new Price[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeDouble(price);
    }
}
