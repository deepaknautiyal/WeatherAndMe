package com.deepaknautiyal.weatherandme.weather.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.deepaknautiyal.weatherandme.R;
import com.deepaknautiyal.weatherandme.weather.weather.DailyWeather;

/**
 * Created by deepak.nautiyal on 5/13/16.
 */
public class DayAdapter extends BaseAdapter {

    public static final String TAG_DAY_ADAPTER = DayAdapter.class.getSimpleName();

    private Context mContext;
    private DailyWeather[] mDailyWeather;

    public DayAdapter(Context context, DailyWeather[] dailyWeather){
        Log.d(TAG_DAY_ADAPTER,"DayAdapter Initiated");

        mContext = context;
        mDailyWeather = dailyWeather;

        Log.d(TAG_DAY_ADAPTER,"context and array set");
    }

    @Override
    public int getCount() {
        Log.d(TAG_DAY_ADAPTER,mDailyWeather.length+"");
        return mDailyWeather.length;
    }

    @Override
    public Object getItem(int position) {
        Log.d(TAG_DAY_ADAPTER,"Position inside DayAdapter getItem is - "+position);
        return mDailyWeather[position];
    }

    @Override
    public long getItemId(int position) {
        return 0; // We will not use this method.
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG_DAY_ADAPTER,"Inside getView method");

        ViewHolder holder;

        if(convertView == null){

            Log.d(TAG_DAY_ADAPTER, "Inside IF block in DayAdapter");

            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item,null);

            Log.d(TAG_DAY_ADAPTER, "Layout Inflated");

            holder = new ViewHolder();

            Log.d(TAG_DAY_ADAPTER, "ViewHolder created");

            holder.icomImageView = (ImageView)convertView.findViewById(R.id.iconImageView);
            holder.tempratureLabel=(TextView)convertView.findViewById(R.id.tempratureLabel);
            holder.dayNameLabel = (TextView)convertView.findViewById(R.id.dayNameLabel);

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }

        DailyWeather dailyWeather = mDailyWeather[position];

        Log.d(TAG_DAY_ADAPTER, "IconId - " + dailyWeather.getIconId());
        Log.d(TAG_DAY_ADAPTER, "MaxTemperature - " + dailyWeather.getMaxTemperature());
        Log.d(TAG_DAY_ADAPTER, "DayOfTheWeek - " + dailyWeather.getDayOfTheWeek());

        holder.icomImageView.setImageResource(dailyWeather.getIconId());
        holder.tempratureLabel.setText(dailyWeather.getMaxTemperature() + "");
        if(position == 0){
            holder.dayNameLabel.setText("Today");
        }
        else{
            holder.dayNameLabel.setText(dailyWeather.getDayOfTheWeek());
        }

        return convertView;
    }

    public static class ViewHolder{
        ImageView icomImageView;
        TextView tempratureLabel;
        TextView dayNameLabel;
    }
}
