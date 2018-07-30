
package com.nytarticles.assessment.model;

import com.google.gson.annotations.SerializedName;

public class MediaMetadata {

    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }

}
