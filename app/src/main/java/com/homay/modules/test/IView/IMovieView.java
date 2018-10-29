package com.homay.modules.test.IView;

import com.homay.modules.test.model.Movie;

public interface IMovieView {
    void updateView(Movie movie);
    void onError(String result);
}
