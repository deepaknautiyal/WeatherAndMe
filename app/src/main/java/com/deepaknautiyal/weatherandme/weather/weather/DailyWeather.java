package com.deepaknautiyal.weatherandme.weather.weather;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by deepak.nautiyal on 12/31/15.
 */
public class DailyWeather implements Parcelable {

    public static final String TAG_DAILY_WEATHER = DailyWeather.class.getSimpleName();

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

    public int getMaxTemperature() {
        return (int)Math.round(mMaxTemperature);
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

    public int getIconId(){
        return Forecast.getIconId(mIcon);
    }

    public String getDayOfTheWeek(){
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
        formatter.setTimeZone(TimeZone.getTimeZone(mTimezone));
        Date dateTime = new Date(mTime * 1000);
        return formatter.format(dateTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mTime);
        dest.writeString(mSummary);
        dest.writeDouble(mMaxTemperature);
        dest.writeString(mTimezone);
        dest.writeString(mIcon);
    }

    private DailyWeather(Parcel in){
        mTime = in.readLong();
        mSummary = in.readString();
        mMaxTemperature = in.readDouble();
        mTimezone = in.readString();
        mIcon = in.readString();

        Log.d(TAG_DAILY_WEATHER,mTime+" , "+mSummary+" , "+mMaxTemperature+" , "+mTimezone+" , "+mIcon);

    }

    public DailyWeather(){ }

    public static Creator<DailyWeather> CREATOR = new Creator<DailyWeather>() {
        @Override
        public DailyWeather createFromParcel(Parcel source) {
            return new DailyWeather(source);
        }

        @Override
        public DailyWeather[] newArray(int size) {
            return new DailyWeather[size];
        }
    };
}
