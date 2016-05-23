package com.deepaknautiyal.weatherandme.weather.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.deepaknautiyal.weatherandme.R;
import com.deepaknautiyal.weatherandme.weather.weather.HourlyWeather;

/**
 * Created by deepak.nautiyal on 5/20/16.
 */
public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder> {

    public static final String TAG_HOUR_ADAPTER = HourAdapter.class.getSimpleName();

    private HourlyWeather[] mHourlyWeathers;

    public HourAdapter(HourlyWeather[] hourlyWeathers){
        mHourlyWeathers = hourlyWeathers;
        Log.d(TAG_HOUR_ADAPTER, "Hour Adapter initiated");
    }

    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG_HOUR_ADAPTER,"ViewHolder initiated");
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hourly_item_list, parent, false);
        Log.d(TAG_HOUR_ADAPTER,"Layout Inflated");
        HourViewHolder viewHolder = new HourViewHolder(view);

        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return mHourlyWeathers.length;
    }

    @Override
    public void onBindViewHolder(HourViewHolder holder, int position) {
        holder.bindHour(mHourlyWeathers[position]);
        Log.d(TAG_HOUR_ADAPTER,"Data bound to view");

    }

    public class HourViewHolder extends RecyclerView.ViewHolder{

        public TextView mTimeLabel;
        public TextView mTemperatureLabel;
        public TextView mSummaryLabel;
        public ImageView mIconImageView;

        public HourViewHolder(View itemView) {
            super(itemView);

            Log.d(TAG_HOUR_ADAPTER,"Hour View holder initiated");

            mTimeLabel = (TextView)itemView.findViewById(R.id.timeLabel);
            mTemperatureLabel=(TextView) itemView.findViewById(R.id.hourlyTemperatureLabel);
            mSummaryLabel=(TextView)itemView.findViewById(R.id.summaryLabel);
            mIconImageView=(ImageView)itemView.findViewById(R.id.iconImageView);

            Log.d(TAG_HOUR_ADAPTER,"Hour view data initiated");
        }

        public void bindHour(HourlyWeather hourlyWeather){
            Log.d(TAG_HOUR_ADAPTER,"Entered bindHour method");

            mTimeLabel.setText(hourlyWeather.getHour());
            Log.d(TAG_HOUR_ADAPTER,"Time Label Set");

            mTemperatureLabel.setText(hourlyWeather.getTemperature()+" ");
            Log.d(TAG_HOUR_ADAPTER,"Temperature Label set");

            mSummaryLabel.setText(hourlyWeather.getSummary());
            Log.d(TAG_HOUR_ADAPTER,"Summary Label set");

            mIconImageView.setImageResource(hourlyWeather.getIconId());
            Log.d(TAG_HOUR_ADAPTER,"Image View set");

        }
    }
}
