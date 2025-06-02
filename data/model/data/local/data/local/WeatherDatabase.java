package com.flam.weathertrack.data.local;

import android.content.Context;
import androidx.room.*;

import com.flam.weathertrack.data.model.WeatherData;

@Database(entities = {WeatherData.class}, version = 1, exportSchema = false)
public abstract class WeatherDatabase extends RoomDatabase {

    private static WeatherDatabase instance;

    public abstract WeatherDao weatherDao();

    public static synchronized WeatherDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                WeatherDatabase.class, "weather_db")
                .fallbackToDestructiveMigration()
                .build();
        }
        return instance;
    }
}
