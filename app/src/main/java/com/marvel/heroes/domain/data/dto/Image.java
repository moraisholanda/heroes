package com.marvel.heroes.domain.data.dto;

import android.os.Parcelable;

/**
 * Created by sergio on 19/06/16.
 */

public class Image implements Parcelable {
    public String path;

    public String extension;

    public String pathPortraitMedium;

    public String pathPortraitSmall;

    public String pathPortraitLarge;

    public String pathPortraitFantastic;

    public String pathPortraitUncanny;

    public String pathPortraitIncredible;

    protected Image(android.os.Parcel in) {
        path = in.readString();
        extension = in.readString();
        pathPortraitMedium = in.readString();
        pathPortraitSmall = in.readString();
        pathPortraitLarge = in.readString();
        pathPortraitFantastic = in.readString();
        pathPortraitUncanny = in.readString();
        pathPortraitIncredible = in.readString();
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(android.os.Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    public String getPathPortraitMedium() {
        return path.concat("/portrait_medium.jpg");
    }

    public String getPathPortraitSmall() {
        return path.concat("/portrait_small.jpg");
    }

    public String getPathPortraitLarge() {
        return path.concat("/portrait_xlarge.jpg");
    }

    public String getPathPortraitFantastic() {
        return path.concat("/portrait_fantastic.jpg");
    }

    public String getPathPortraitUncanny() {
        return path.concat("/portrait_uncanny.jpg");
    }

    public String getPathPortraitIncredible() {
        return path.concat("/portrait_incredible.jpg");
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeString(path);
        dest.writeString(extension);
        dest.writeString(pathPortraitMedium);
        dest.writeString(pathPortraitSmall);
        dest.writeString(pathPortraitLarge);
        dest.writeString(pathPortraitFantastic);
        dest.writeString(pathPortraitUncanny);
        dest.writeString(pathPortraitIncredible);
    }
}
