package com.flam.weathertrack.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import com.flam.weathertrack.data.model.WeatherData;

import java.util.List;

@Dao
public interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(WeatherData data);

    @Query("SELECT * FROM weather_table ORDER BY date DESC LIMIT 7")
    LiveData<List<WeatherData>> getLast7Days();
}
