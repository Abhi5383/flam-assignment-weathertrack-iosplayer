package com.flam.weathertrack.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "weather_table")
public class WeatherData {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String date;
    public int temperature;
    public int humidity;
    public String condition;

    public WeatherData(String date, int temperature, int humidity, String condition) {
        this.date = date;
        this.temperature = temperature;
        this.humidity = humidity;
        this.condition = condition;
    }
}
