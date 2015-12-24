package com.deepaknautiyal.weatherandme;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private CurrentWeather mCurrentWeather;

    @Bind(R.id.timeLabel) TextView mTimeLabel;
    @Bind(R.id.tempratureLabel) TextView mTempratureLabel;
    @Bind(R.id.humidityValue) TextView mHumidityValue;
    @Bind(R.id.precipValue) TextView mPrecipValue;
    @Bind(R.id.summaryLabel) TextView mSummary;
    @Bind(R.id.iconImageView) ImageView mIconImage;
    @Bind(R.id.refreshImageView) ImageView mRefreshImage;
    @Bind(R.id.progressBar) ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mProgressBar.setVisibility(View.INVISIBLE);

        final double latitude = 12.903238;
        final double longitude = 77.647602;

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        mRefreshImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getForecast(latitude,longitude);
            }
        });

        getForecast(latitude,longitude);

        Log.d(TAG, "This is running on Main thread");

    }

    private void getForecast(double latitude, double longitude) {
        String apiKey="18af80f34789e79fdb227a9fbc522fcd";
        String forecastUrl = "https://api.forecast.io/forecast/"
                +apiKey+"/"+latitude+","+longitude;


        if(isNetworkAvailable()) {
            toggleRefresh();
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(forecastUrl).build();
            Call call = client.newCall(request);

            call.enqueue(new Callback() {
                @Override
                public void onFailure(Request request, IOException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            toggleRefresh();
                        }
                    });
                    Log.v(TAG, "Network call failed");
                }

                @Override
                public void onResponse(Response response) throws IOException {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            toggleRefresh();
                        }
                    });

                    try {
                        String jsonData = response.body().string();
                        Log.v(TAG, jsonData);
                        if (response.isSuccessful()) {
                            mCurrentWeather = getCurrentData(jsonData);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    updateDisplay();
                                }
                            });
                        } else {
                            alertUser();
                        }

                    }
                    catch (IOException e) {
                        Log.e(TAG, "IOException caught: " + e);
                    }
                    catch (JSONException e){
                        Log.e(TAG, "JSONException caught: " + e);
                    }
                }
            });
        }
        else{
            Toast.makeText(MainActivity.this, R.string.network_unavailable_msg,
                    Toast.LENGTH_LONG).show();
        }
    }

    private void toggleRefresh(){
        if(mProgressBar.getVisibility() == View.INVISIBLE){
            mProgressBar.setVisibility(View.VISIBLE);
            mRefreshImage.setVisibility(View.INVISIBLE);
        }
        else{
            mProgressBar.setVisibility(View.INVISIBLE);
            mRefreshImage.setVisibility(View.VISIBLE);
        }
    }

    private void updateDisplay() {
        mTimeLabel.setText("At " + mCurrentWeather.getFormattedTime() + " it will be");
        mTempratureLabel.setText(mCurrentWeather.getTempInCelcius()+"");
        mHumidityValue.setText(mCurrentWeather.getHumidity()+"");
        mPrecipValue.setText(mCurrentWeather.getChanceOfRain() + "%");
        mSummary.setText("The weather is " + mCurrentWeather.getSummary());
        Drawable drawable = getResources().getDrawable(mCurrentWeather.getIconId());
        mIconImage.setImageDrawable(drawable);
    }

    private CurrentWeather getCurrentData(String jsonData) throws JSONException {
        CurrentWeather currentWeather = new CurrentWeather();

        JSONObject forecastJson = new JSONObject(jsonData);
        currentWeather.setTimeZone(forecastJson.getString("timezone"));

        JSONObject currentlyJson = forecastJson.getJSONObject("currently");
        currentWeather.setTime(currentlyJson.getLong("time"));
        currentWeather.setChanceOfRain(currentlyJson.getLong("precipProbability"));
        currentWeather.setHumidity(currentlyJson.getLong("humidity"));
        currentWeather.setTemprature(currentlyJson.getLong("temperature"));
        currentWeather.setSummary(currentlyJson.getString("summary"));
        currentWeather.setIcon(currentlyJson.getString("icon"));

        Log.d(TAG, "Formatted Date Time: " + currentWeather.getFormattedTime());

        return currentWeather;
    }

    private boolean isNetworkAvailable() {
        boolean isAvailable = false;
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()){
            isAvailable = true;
        }
        return isAvailable;
    }

    private void alertUser() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(),getString(R.string.error_alert_dialog_res));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
