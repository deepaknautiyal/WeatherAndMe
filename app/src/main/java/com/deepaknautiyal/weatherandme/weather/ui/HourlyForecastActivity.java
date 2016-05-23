package com.deepaknautiyal.weatherandme.weather.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.deepaknautiyal.weatherandme.R;
import com.deepaknautiyal.weatherandme.weather.adapters.HourAdapter;
import com.deepaknautiyal.weatherandme.weather.weather.HourlyWeather;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HourlyForecastActivity extends AppCompatActivity {

    private HourlyWeather[] mHourlyWeathers;

    public static final String TAG_HOURLY_FORECAST = HourlyForecastActivity.class.getSimpleName();

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_forecast);
        ButterKnife.bind(this);

        Log.d(TAG_HOURLY_FORECAST,"Inside HourlyForecastActivity");

        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.HOURLY_FORECAST);

        Log.d(TAG_HOURLY_FORECAST,"Parcelable Created");

        mHourlyWeathers = Arrays.copyOf(parcelables,parcelables.length,HourlyWeather[].class);

        Log.d(TAG_HOURLY_FORECAST, "Daily Weather Object created from parcelable");

        HourAdapter adapter = new HourAdapter(mHourlyWeathers);
        mRecyclerView.setAdapter(adapter);

        Log.d(TAG_HOURLY_FORECAST, "HourAdapter Invoked");

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        Log.d(TAG_HOURLY_FORECAST, "LayoutManager invoked");

        mRecyclerView.setHasFixedSize(true);

        Log.d(TAG_HOURLY_FORECAST, "Recycler has fixed size");

    }

}
