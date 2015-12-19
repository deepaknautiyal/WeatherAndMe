package com.deepaknautiyal.weatherandme;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by deepak.nautiyal on 12/15/15.
 */
public class CurrentWeather {

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
        int iconId = R.mipmap.clear_day;

        if (mIcon.equals("clear-day")) {
            iconId = R.mipmap.clear_day;
        }
        else if (mIcon.equals("clear-night")) {
            iconId = R.mipmap.clear_night;
        }
        else if (mIcon.equals("rain")) {
            iconId = R.mipmap.rain;
        }
        else if (mIcon.equals("snow")) {
            iconId = R.mipmap.snow;
        }
        else if (mIcon.equals("sleet")) {
            iconId = R.mipmap.sleet;
        }
        else if (mIcon.equals("wind")) {
            iconId = R.mipmap.wind;
        }
        else if (mIcon.equals("fog")) {
            iconId = R.mipmap.fog;
        }
        else if (mIcon.equals("cloudy")) {
            iconId = R.mipmap.cloudy;
        }
        else if (mIcon.equals("partly-cloudy-day")) {
            iconId = R.mipmap.partly_cloudy;
        }
        else if (mIcon.equals("partly-cloudy-night")) {
            iconId = R.mipmap.cloudy_night;
        }

        return iconId;
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

    public long getTemprature() {
        return mTemprature;
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

    public long getChanceOfRain() {
        return mChanceOfRain;
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
}
