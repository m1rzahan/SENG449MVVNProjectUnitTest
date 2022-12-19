package com.okay.seng449mvvm;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.okay.seng449mvvm.Adapters.WeatherAdapter;
import com.okay.seng449mvvm.Base.BaseActivityCompat;
import com.okay.seng449mvvm.ViewModel.WeatherViewModel;
import com.okay.seng449mvvm.Weather.Result;

import java.util.ArrayList;

public class WeatherActivity extends BaseActivityCompat {

    private WeatherViewModel weatherViewModel;

    private RecyclerView dataListRecyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);

        dataListRecyclerView = findViewById(R.id.dataListRecyclerView);

        weatherViewModel.getWeatherData("ankara");

        observeViewModel();

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_weather;
    }

    private void observeViewModel() {
        weatherViewModel.loading.observe(this,isLoading->{
            if(isLoading != null)
            {
                if(isLoading)
                {
                    showLoading();
                }
                else
                {
                    hideLoading();
                }
            }
        });

        weatherViewModel.validationError.observe(this,isValidationError->{
            if(isValidationError != null)
            {
                if(isValidationError)
                {
                    // validasyon hatası gösterilecek.
                }
                else
                {
                    // validasyon hatası gösterilecek.
                }
            }
        });


        weatherViewModel.results.observe(this,resultArrayList->{
            if(resultArrayList != null && resultArrayList.size()>0)
            {
                diplayListData(resultArrayList);
            }
        });
    }

    private void diplayListData(ArrayList<Result> resultList)
    {
        WeatherAdapter adapter = new WeatherAdapter(resultList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        dataListRecyclerView.setLayoutManager(mLayoutManager);
        dataListRecyclerView.setAdapter(adapter);
    }



}