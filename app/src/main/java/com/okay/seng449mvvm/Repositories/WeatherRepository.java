package com.okay.seng449mvvm.Repositories;

import android.content.Context;
import android.net.ConnectivityManager;

import com.okay.seng449mvvm.App.App;
import com.okay.seng449mvvm.Interface.WeatherNetworkHandler;
import com.okay.seng449mvvm.Interface.WeatherRepositoryHandler;
import com.okay.seng449mvvm.Network.WeatherNetwork;
import com.okay.seng449mvvm.Weather.Result;

import java.util.ArrayList;

public class WeatherRepository implements WeatherNetworkHandler {

    // bu clas iki şeye sahip olacak.
    // 1. networ den data alacak.
    // 2. DB den data alacak.
    private WeatherRepositoryHandler weatherRepositoryHandler;


    public WeatherRepository()
    {

    }

    public void getData(String city, WeatherRepositoryHandler weatherRepositoryHandler)
    {
        this.weatherRepositoryHandler = weatherRepositoryHandler;

        boolean isNetworkOpen = isNetworkAvailable(App.getInstance().getAppContext());

        if(isNetworkOpen)
        {
            String apiKey = "2Stxlk4jSx7jEwkTpUOGi9:2hTZLp49lZk7vzGNpf3ccy";
            WeatherNetwork weatherNetwork = new WeatherNetwork();
            weatherNetwork.getData(city,apiKey,this);
        }
        else
        {
            //DB den data geldi mi?
        }
    }

    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }


    @Override
    public void onSuccess(ArrayList<Result> resultList) {
        weatherRepositoryHandler.onSuccess(resultList);
    }

    @Override
    public void onFail() {
        //Db den data alacak.
        weatherRepositoryHandler.onFail();
    }
}
