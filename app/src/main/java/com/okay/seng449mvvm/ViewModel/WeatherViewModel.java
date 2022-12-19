package com.okay.seng449mvvm.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.okay.seng449mvvm.Interface.WeatherRepositoryHandler;
import com.okay.seng449mvvm.Repositories.WeatherRepository;
import com.okay.seng449mvvm.Weather.Result;

import java.util.ArrayList;

public class WeatherViewModel extends ViewModel implements WeatherRepositoryHandler {

    public MutableLiveData<Boolean> loading = new MutableLiveData<Boolean>();
    public MutableLiveData<ArrayList<Result>> results = new MutableLiveData<ArrayList<Result>>();
    public MutableLiveData<Boolean> loadError = new MutableLiveData<Boolean>();
    public MutableLiveData<Boolean> validationError = new MutableLiveData<Boolean>();

    private WeatherRepository weatherRepository;



    public WeatherViewModel() {
        super();
        weatherRepository = new WeatherRepository();
    }

    public void getWeatherData(String city)
    {
        if(city != null && !city.trim().isEmpty())
        {
            loading.setValue(true);
            weatherRepository.getData("ankara",this);
        }
        else
        {
            validationError.setValue(true);
        }
    }

    @Override
    public void onSuccess(ArrayList<Result> resultList) {
        loading.setValue(false);
        results.setValue(resultList);
    }

    @Override
    public void onFail() {
        loading.setValue(false);
    }
}
