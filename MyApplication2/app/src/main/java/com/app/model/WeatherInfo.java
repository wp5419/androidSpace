package com.app.model;

import java.io.Serializable;

/**
 * Created by wafer on 2016/9/22.
 */

public class WeatherInfo implements Serializable {
    private String date;
    private String dayPicUrl;
    private String nightPicUrl;
    private String weather;
    private String wind;
    private String temperature;


    public String getDate() {
        return date;
    }

    public String getDayPicUrl() {
        return dayPicUrl;
    }

    public String getNightPicUrl() {
        return nightPicUrl;
    }

    public String getWeather() {
        return weather;
    }

    public String getWind() {
        return wind;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDayPicUrl(String dayPicUrl) {
        this.dayPicUrl = dayPicUrl;
    }

    public void setNightPicUrl(String nightPicUrl) {
        this.nightPicUrl = nightPicUrl;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }


}
