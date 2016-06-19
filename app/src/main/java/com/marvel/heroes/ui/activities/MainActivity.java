package com.marvel.heroes.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.marvel.heroes.R;
import com.marvel.heroes.domain.data.api.ApiFactory;
import com.marvel.heroes.domain.data.dto.Comics;
import com.marvel.heroes.domain.data.interceptor.SharedConstantsApiUtils;
import com.marvel.heroes.domain.data.response.DataCollectionResponse;
import com.marvel.heroes.domain.data.response.SimpleObserver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by sergio on 19/06/16.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);
    }

    void teste(){
        Map<String, String> mapQuery = new HashMap<>();
        // mapQuery.put("contributor[]", String.valueOf(id));
        mapQuery.put(SharedConstantsApiUtils.TS,"1");
        mapQuery.put(SharedConstantsApiUtils.APIKEY,"bb4470a46d0659a43c566ac6056ed48d");
        mapQuery.put(SharedConstantsApiUtils.HASH,"479474cf0a28eac9998960da4d96f06b");

        ApiFactory.comicsMarvelApi().getComics(1009610,mapQuery).map(new Func1<DataCollectionResponse<List<Comics>>, List<Comics>>() {
            @Override
            public List<Comics> call(DataCollectionResponse<List<Comics>> listDataCollectionResponse) {
                return  listDataCollectionResponse.data.results;
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SimpleObserver<List<Comics>>(){
                    @Override
                    public void onNext(List<Comics> comicses) {
                        Log.d(getClass().getSimpleName(), "comics ! "+comicses.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(getClass().getSimpleName(), "Error get profile! " +e.getMessage());
                    }
                });
    }
}
