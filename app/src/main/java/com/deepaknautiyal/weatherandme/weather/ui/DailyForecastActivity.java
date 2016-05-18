package com.deepaknautiyal.weatherandme.weather.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.deepaknautiyal.weatherandme.R;
import com.deepaknautiyal.weatherandme.weather.adapters.DayAdapter;
import com.deepaknautiyal.weatherandme.weather.weather.DailyWeather;

import java.util.Arrays;

public class DailyForecastActivity extends ListActivity {

    public static final String TAG_DAILY_FORECAST = DailyForecastActivity.class.getSimpleName();

    private DailyWeather[] mDailyWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.d(TAG_DAILY_FORECAST, "Inside DailyForecastActivity");

        Intent intent = getIntent();
        Parcelable[] parcelable = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);

        Log.d(TAG_DAILY_FORECAST,"Parcelable Created");

        mDailyWeather = Arrays.copyOf(parcelable, parcelable.length,DailyWeather[].class);

        Log.d(TAG_DAILY_FORECAST,"Daily Weather Object created from parcelable");

        DayAdapter adapter = new DayAdapter(this, mDailyWeather);
        setListAdapter(adapter);

    }

}
