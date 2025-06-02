package com.flam.weathertrack.repository;

import android.content.Context;
import androidx.lifecycle.LiveData;

import com.flam.weathertrack.data.local.WeatherDao;
import com.flam.weathertrack.data.local.WeatherDatabase;
import com.flam.weathertrack.data.model.WeatherData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeatherRepository {

    private final WeatherDao dao;
    private final ExecutorService executorService;

    public WeatherRepository(Context context) {
        WeatherDatabase db = WeatherDatabase.getInstance(context);
        dao = db.weatherDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<WeatherData>> getLast7Days() {
        return dao.getLast7Days();
    }

    public void insert(WeatherData data) {
        executorService.execute(() -> dao.insert(data));
    }
}
