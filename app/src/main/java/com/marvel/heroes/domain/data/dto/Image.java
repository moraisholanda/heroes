package com.marvel.heroes.domain.data.dto;

import org.parceler.Parcel;

/**
 * Created by sergio on 19/06/16.
 */
@Parcel
public class Image {
    public String path;

    public String extension;

    public String pathPortraitMedium;

    public String pathPortraitSmall;

    public String pathPortraitLarge;

    public String pathPortraitFantastic;

    public String pathPortraitUncanny;

    public String pathPortraitIncredible;

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
}
