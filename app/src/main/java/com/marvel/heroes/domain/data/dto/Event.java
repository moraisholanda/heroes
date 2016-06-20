package com.marvel.heroes.domain.data.dto;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by sergio on 19/06/16.
 */
@Parcel
public class Event {

    public String collectionURI;

    public List<Items> items;

    public Integer returned;

    public Integer available;
}
