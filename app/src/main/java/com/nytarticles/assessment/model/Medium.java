
package com.nytarticles.assessment.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Medium {

    @SerializedName("caption")
    private String caption;
    @SerializedName("media-metadata")
    private List<MediaMetadata> mediaMetadata = null;

    public String getCaption() {
        return caption;
    }

    public List<MediaMetadata> getMediaMetadata() {
        return mediaMetadata;
    }

}
