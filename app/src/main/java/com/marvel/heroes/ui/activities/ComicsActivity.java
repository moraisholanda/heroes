package com.marvel.heroes.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.marvel.heroes.R;
import com.marvel.heroes.domain.data.api.ApiFactory;
import com.marvel.heroes.domain.data.dto.Comics;
import com.marvel.heroes.domain.data.interceptor.SharedConstantsApiUtils;
import com.marvel.heroes.domain.data.response.DataResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by sergio on 19/06/16.
 */
public class ComicsActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        button = (Button) findViewById(R.id.click);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teste();
            }
        });
    }


   private  void teste(){
        Map<String, String> mapQuery = new HashMap<>();
        Log.d(getClass().getSimpleName(), "clck ! ");
        mapQuery.put(SharedConstantsApiUtils.TS,"1");
        mapQuery.put(SharedConstantsApiUtils.APIKEY,"bb4470a46d0659a43c566ac6056ed48d");
        mapQuery.put(SharedConstantsApiUtils.HASH,"479474cf0a28eac9998960da4d96f06b");

        ApiFactory.comicsMarvelApi().getComics(1009610,"1","bb4470a46d0659a43c566ac6056ed48d","479474cf0a28eac9998960da4d96f06b")
                .subscribeOn(Schedulers.io())
                .map(r -> r.data)
                .doOnError(error -> onError(error))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onResponseUpdate, error -> onError(error));
    }

    private void onResponseUpdate(DataResult<List<Comics>> listDataResult) {
        Log.d(getClass().getSimpleName(), "response ! "+listDataResult.results.size());
    }

    private void onError(Throwable error) {
        Log.d(getClass().getSimpleName(), "error ! "+error.getMessage());
    }

}
