package com.deepaknautiyal.weatherandme.weather.weather;

/**
 * Created by deepak.nautiyal on 12/31/15.
 */
public class Forecast {

    private CurrentWeather mCurrentWeather;
    private HourlyWeather[] mHourlyWeathers;
    private DailyWeather[] mDailyWeathers;

    public CurrentWeather getCurrentWeather() {
        return mCurrentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        mCurrentWeather = currentWeather;
    }

    public HourlyWeather[] getHourlyWeathers() {
        return mHourlyWeathers;
    }

    public void setHourlyWeathers(HourlyWeather[] hourlyWeathers) {
        mHourlyWeathers = hourlyWeathers;
    }

    public DailyWeather[] getDailyWeathers() {
        return mDailyWeathers;
    }

    public void setDailyWeathers(DailyWeather[] dailyWeathers) {
        mDailyWeathers = dailyWeathers;
    }
}
