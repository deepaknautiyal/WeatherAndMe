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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.deepaknautiyal.weatherandme.R;
import com.deepaknautiyal.weatherandme.weather.adapters.DayAdapter;
import com.deepaknautiyal.weatherandme.weather.weather.DailyWeather;

import java.util.Arrays;

import butterknife.Bind;

public class DailyForecastActivity extends ListActivity {

    public static final String TAG_DAILY_FORECAST = DailyForecastActivity.class.getSimpleName();

    private DailyWeather[] mDailyWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        Log.d(TAG_DAILY_FORECAST, "Inside DailyForecastActivity");

        Intent intent = getIntent();
        Parcelable[] parcelable = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);

        Log.d(TAG_DAILY_FORECAST,"Parcelable Created");

        mDailyWeather = Arrays.copyOf(parcelable, parcelable.length,DailyWeather[].class);

        Log.d(TAG_DAILY_FORECAST,"Daily Weather Object created from parcelable");

        DayAdapter adapter = new DayAdapter(this, mDailyWeather);
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String dayOfTheWeek = mDailyWeather[position].getDayOfTheWeek();
        String summary = mDailyWeather[position].getSummary();
        String maxTemp = mDailyWeather[position].getMaxTemperature()+"";
        String message = String.format("On %s the high temperature will be %s and conditions will be %s",
                dayOfTheWeek, maxTemp, summary);

        Toast.makeText(this,message,Toast.LENGTH_LONG).show();

    }
}
