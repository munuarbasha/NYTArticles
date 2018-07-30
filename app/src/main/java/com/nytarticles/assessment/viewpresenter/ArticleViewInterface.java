package com.nytarticles.assessment.viewpresenter;

import com.nytarticles.assessment.model.Response;

public interface ArticleViewInterface {

    void displayArticles(Response response);
    void displayError(String errorMessage);
}
