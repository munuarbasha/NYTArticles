
package com.nytarticles.assessment.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {

    @SerializedName("status")
    private String status;
    @SerializedName("results")
    private List<Result> results = null;

    public List<Result> getResults() {
        return results;
    }

}
