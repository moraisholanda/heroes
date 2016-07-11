package com.marvel.heroes.domain.data.dto;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by sergio on 19/06/16.
 */

@Parcel
public class Comics {
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
}
