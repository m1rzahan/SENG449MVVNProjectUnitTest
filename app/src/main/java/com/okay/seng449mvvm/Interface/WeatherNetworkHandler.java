package com.okay.seng449mvvm.Interface;

import com.okay.seng449mvvm.Weather.Result;

import java.util.ArrayList;

public interface WeatherNetworkHandler {
    void onSuccess(ArrayList<Result> resultList);
    void onFail();
}
