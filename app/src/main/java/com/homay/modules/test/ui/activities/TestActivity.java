package com.homay.modules.test.ui.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.homay.commons.activities.BaseActivity;
import com.homay.R;
import com.homay.modules.test.model.Movie;
import com.homay.modules.test.presenter.MoviePresenter;
import com.homay.modules.test.IView.IMovieView;

public class TestActivity extends BaseActivity implements IMovieView {

    String TAG = "MainActivity";

    TextView test;

    private MoviePresenter moviePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        addListener();


    }

    private void init(){

        test = this.findViewById(R.id.test);

        moviePresenter = new MoviePresenter(this,this);

        progressDialog = new ProgressDialog(this);

    }

    private void addListener(){
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                moviePresenter.load_data();
            }
        });
    }

    ProgressDialog progressDialog;


    @Override
    public void updateView(Movie movie) {

        progressDialog.dismiss();

        test.setText(movie.getTitle());

    }

    @Override
    public void onError(String result) {
        progressDialog.dismiss();

        test.setText(result);
    }
}
