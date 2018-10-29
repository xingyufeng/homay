package com.homay.commons.activities;

import android.os.Bundle;
import android.util.Log;

import com.homay.commons.HttpUtils.ApiMethods;
import com.homay.commons.HttpUtils.MyObserver;
import com.homay.commons.HttpUtils.ObserverOnNextListener;
import com.homay.R;
import com.homay.modules.test.model.Movie;
import com.homay.modules.test.model.Subjects;

import java.util.List;

public class MainActivity extends BaseActivity {

    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        load_data();

    }

    private void load_data(){
        ObserverOnNextListener<Movie> listener = new ObserverOnNextListener<Movie>() {
            @Override
            public void onNext(Movie movie) {
                Log.d(TAG, "onNext: " + movie.getTitle());
                List<Subjects> list = movie.getSubjects();
                for (Subjects sub : list) {
                    Log.d(TAG, "onNext: " + sub.getId() + "," + sub.getYear() + "," + sub.getTitle());
                }
            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(Throwable e) {

            }

        };
        ApiMethods.getTopMovie(new MyObserver<Movie>(this, listener), 0, 10);

    }


}
