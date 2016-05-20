package com.deepaknautiyal.weatherandme.weather.weather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by deepak.nautiyal on 12/31/15.
 */
public class HourlyWeather implements Parcelable {

    private long mTime;
    private String mSummary;
    private double mTemperature;
    private String mTimezone;
    private String mIcon;

    public HourlyWeather() { }

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

    public double getTemperature() {
        return mTemperature;
    }

    public void setTemperature(double temperature) {
        mTemperature = temperature;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mTime);
        dest.writeString(mSummary);
        dest.writeDouble(mTemperature);
        dest.writeString(mTimezone);
        dest.writeString(mIcon);
    }

    private HourlyWeather(Parcel in){
        mTime=in.readLong();
        mSummary=in.readString();
        mTemperature=in.readDouble();
        mTimezone=in.readString();
        mIcon=in.readString();
    }

    public static final Creator<HourlyWeather> CREATOR = new Creator<HourlyWeather>() {
        @Override
        public HourlyWeather createFromParcel(Parcel source) {
            return new HourlyWeather(source);
        }

        @Override
        public HourlyWeather[] newArray(int size) {
            return new HourlyWeather[size];
        }
    };
}
