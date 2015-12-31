package com.deepaknautiyal.weatherandme.weather.weather;

/**
 * Created by deepak.nautiyal on 12/31/15.
 */
public class DailyWeather {

    private long mTime;
    private String mSummary;
    private double mMaxTemperature;
    private String mTimezone;
    private String mIcon;

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public double getMaxTemperature() {
        return mMaxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        mMaxTemperature = maxTemperature;
    }

    public String getTimezone() {
        return mTimezone;
    }

    public void setTimezone(String timezone) {
        mTimezone = timezone;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }
}
