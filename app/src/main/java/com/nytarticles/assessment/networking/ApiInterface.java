package com.nytarticles.assessment.networking;

import com.nytarticles.assessment.model.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=aea8b7c7a56e4bdd994a1325a61869ec")
    Observable<Response> getMostPopularArticles();
}
