package com.marvel.heroes.domain.data.dto;

import android.os.Parcel;
import android.os.Parcelable;


import java.util.List;

/**
 * Created by sergio on 19/06/16.
 */

public class Comics implements Parcelable {
    public long id;

    public long digitalId;

    public String title;

    public int issueNumber;

    public String variantDescription;

    public String description;

    public String modified;

    public String isbn;

    public String upc;

    public String diamondCode;

    public String ean;

    public String issn;

    public String format;

    public int pageCount;

    public String name;

    public Image thumbnail;

    public Event comics;

    public Serie series;

    public Storie stories;

    public List<Image> images;

    public List<Price> prices;

    public Comics(String title, int issueNumber) {
        this.title = title;
        this.issueNumber = issueNumber;
    }


    protected Comics(Parcel in) {
        id = in.readLong();
        digitalId = in.readLong();
        title = in.readString();
        issueNumber = in.readInt();
        variantDescription = in.readString();
        description = in.readString();
        modified = in.readString();
        isbn = in.readString();
        upc = in.readString();
        diamondCode = in.readString();
        ean = in.readString();
        issn = in.readString();
        format = in.readString();
        pageCount = in.readInt();
        name = in.readString();
        thumbnail = in.readParcelable(Image.class.getClassLoader());
        images = in.createTypedArrayList(Image.CREATOR);
    }

    public static final Creator<Comics> CREATOR = new Creator<Comics>() {
        @Override
        public Comics createFromParcel(Parcel in) {
            return new Comics(in);
        }

        @Override
        public Comics[] newArray(int size) {
            return new Comics[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeLong(digitalId);
        dest.writeString(title);
        dest.writeInt(issueNumber);
        dest.writeString(variantDescription);
        dest.writeString(description);
        dest.writeString(modified);
        dest.writeString(isbn);
        dest.writeString(upc);
        dest.writeString(diamondCode);
        dest.writeString(ean);
        dest.writeString(issn);
        dest.writeString(format);
        dest.writeInt(pageCount);
        dest.writeString(name);
        dest.writeParcelable(thumbnail, flags);
        dest.writeParcelable(comics, flags);
        dest.writeParcelable(series, flags);
        dest.writeParcelable(stories, flags);
        dest.writeTypedList(images);
        dest.writeTypedList(prices);
    }
}
