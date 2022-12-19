package com.okay.seng449mvvm.Weather;


import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Weather implements Parcelable
{

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("result")
    @Expose
    private List<Result> result = null;
    public final static Creator<Weather> CREATOR = new Creator<Weather>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Weather createFromParcel(android.os.Parcel in) {
            return new Weather(in);
        }

        public Weather[] newArray(int size) {
            return (new Weather[size]);
        }

    };

    protected Weather(android.os.Parcel in) {
        this.success = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.city = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.result, (Result.class.getClassLoader()));
    }

    public Weather() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(success);
        dest.writeValue(city);
        dest.writeList(result);
    }

    public int describeContents() {
        return 0;
    }

}

