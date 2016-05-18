package com.deepaknautiyal.weatherandme.weather.weather;

import com.deepaknautiyal.weatherandme.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by deepak.nautiyal on 12/15/15.
 */
public class CurrentWeather {

    public static final String TAG = CurrentWeather.class.getSimpleName();

    private String mIcon;
    private long mTime;
    private long mTemprature;
    private long mHumidity;
    private long mChanceOfRain;
    private String mSummary;
    private String mTimeZone;

    public String getIcon() {
        return mIcon;
    }

    public int getIconId(){
        return Forecast.getIconId(mIcon);
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public long getTime() {
        return mTime;
    }

    public String getFormattedTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");
        formatter.setTimeZone(TimeZone.getTimeZone(getTimeZone()));
        Date dateTime = new Date(getTime() * 1000);
        String formattedDateTime = formatter.format(dateTime);
        return  formattedDateTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public int getTemprature() {
        return (int) Math.round(mTemprature);
    }

    public void setTemprature(long temprature) {
        mTemprature = temprature;
    }

    public long getHumidity() {
        return mHumidity;
    }

    public void setHumidity(long humidity) {
        mHumidity = humidity;
    }

    public int getChanceOfRain() {
        double mPrecipPercentage = mChanceOfRain * 100;
        return (int) Math.round(mPrecipPercentage);
    }

    public void setChanceOfRain(long chanceOfRain) {
        mChanceOfRain = chanceOfRain;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public String getTimeZone() {
        return mTimeZone;
    }

    public void setTimeZone(String timeZone) {
        mTimeZone = timeZone;
    }

    public int getTempInCelcius(){
        long mTempInCelcius = (long)((mTemprature-32.00)*(5.00/9.00));
        return (int) Math.round(mTempInCelcius);
    }
}
