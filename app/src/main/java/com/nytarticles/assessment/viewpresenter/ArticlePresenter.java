package com.nytarticles.assessment.viewpresenter;

import com.nytarticles.assessment.networking.ApiClient;
import com.nytarticles.assessment.networking.ApiInterface;
import com.nytarticles.assessment.model.Response;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class ArticlePresenter implements ArticlePresenterInterface {

    private ArticleViewInterface articleViewInterface;

    public ArticlePresenter(ArticleViewInterface articleViewInterface) {
        this.articleViewInterface = articleViewInterface;
    }


    @Override
    public void getPopularList() {
        getArticlesObservable().subscribeWith(getObserver());
    }

    private Observable<Response> getArticlesObservable() {
        return ApiClient.getClient().create(ApiInterface.class).getMostPopularArticles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private DisposableObserver<Response> getObserver() {
        return new DisposableObserver<Response>() {
            @Override
            public void onNext(Response response) {
                articleViewInterface.displayArticles(response);
            }

            @Override
            public void onError(Throwable e) {
                Timber.e("Error %s", e.getMessage());
                articleViewInterface.displayError(e.getMessage());
            }

            @Override
            public void onComplete() {
                Timber.d("onComplete Called");
            }
        };
    }
}
