package com.okay.seng449mvvm.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.okay.seng449mvvm.R;
import com.okay.seng449mvvm.Weather.Result;

import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder>  {
    private ArrayList<Result> resultItemList;


    public WeatherAdapter( ArrayList<Result> dutyPharmacyItemList) {
        this.resultItemList = dutyPharmacyItemList;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Result result = resultItemList.get(position);
        holder.degree_txt.setText(result.getDegree());
        holder.day_txt.setText(result.getDay());
        holder.date_txt.setText(result.getDate());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.weather_list_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public int getItemCount() {
        return resultItemList.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView degree_txt;
        private TextView day_txt;
        private TextView date_txt;


        public ViewHolder(View v) {
            super(v);
            degree_txt = v.findViewById(R.id.degree_txt);
            day_txt = v.findViewById(R.id.day_txt);
            date_txt = v.findViewById(R.id.date_txt);
        }
    }


}

