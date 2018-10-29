package com.homay.modules.test.presenter;

import android.content.Context;

import com.homay.commons.HttpUtils.ApiMethods;
import com.homay.commons.HttpUtils.MyObserver;
import com.homay.commons.HttpUtils.ObserverOnNextListener;
import com.homay.modules.test.model.Movie;
import com.homay.modules.test.IView.IMovieView;

public class MoviePresenter implements IPresenter {

    private Context context;

    private IMovieView iMovieView;

    public MoviePresenter(Context context,IMovieView iMovieView) {
        this.context = context;
        this.iMovieView = iMovieView;
    }

    @Override
    public void load_data() {
//        ObserverOnNextListener<Movie> listener = new ObserverOnNextListener<Movie>() {
//            @Override
//            public void onNext(Movie movie) {
//          iMovieView.updateView(movie);
//            }
//        };


        ObserverOnNextListener<Movie> listener = new ObserverOnNextListener<Movie>() {
            @Override
            public void onNext(Movie movie) {
                iMovieView.updateView(movie);
            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(Throwable e) {
                iMovieView.onError(e.toString());
            }
        };

        ApiMethods.getTopMovie(new MyObserver<Movie>(context, listener), 0, 10);
    }

}
