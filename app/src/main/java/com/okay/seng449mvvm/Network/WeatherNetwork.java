package com.okay.seng449mvvm.Network;

import android.os.Looper;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.okay.seng449mvvm.Interface.WeatherNetworkHandler;
import com.okay.seng449mvvm.Interface.WeatherRepositoryHandler;
import com.okay.seng449mvvm.Weather.Result;
import com.okay.seng449mvvm.Weather.Weather;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherNetwork {

    public WeatherNetwork() {
    }

    public void getData(String city, String apiKey, WeatherNetworkHandler weatherNetworkHandler)
    {
        //ankara
        //2Stxlk4jSx7jEwkTpUOGi9:2hTZLp49lZk7vzGNpf3ccy
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        Request request = new Request.Builder()
                .url("https://api.collectapi.com/weather/getWeather?data.lang=tr&data.city=" + city)
                .method("GET", null)
                .addHeader("authorization", "apikey " + apiKey)
                .addHeader("content-type", "application/json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

                android.os.Handler threadHandler = new android.os.Handler(Looper.getMainLooper());

                threadHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        weatherNetworkHandler.onFail();
                    }
                });


                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()) {
                    final String myResponse = response.body().string();

                    Weather weather = new Gson().fromJson(myResponse,Weather.class);

                    ArrayList<Result> resultList = new ArrayList<Result>(weather.getResult());


                    android.os.Handler threadHandler = new android.os.Handler(Looper.getMainLooper());

                    threadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            weatherNetworkHandler.onSuccess(resultList);
                        }
                    });



                }
            }
        });
    }
}
