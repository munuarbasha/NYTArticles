
package com.nytarticles.assessment.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("url")
    private String url;
    @SerializedName("byline")
    private String byline;
    @SerializedName("type")
    private String type;
    @SerializedName("title")
    private String title;
    @SerializedName("abstract")
    private String resAbstract;
    @SerializedName("published_date")
    private String publishedDate;
    @SerializedName("source")
    private String source;
    @SerializedName("media")
    private List<Medium> media = null;

    public String getByline() {
        return byline;
    }

    public String getTitle() {
        return title;
    }

    public String getAbstract() {
        return resAbstract;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getSource() {
        return source;
    }

    public List<Medium> getMedia() {
        return media;
    }

}
