package com.flam.weathertrack.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.flam.weathertrack.data.model.WeatherData;
import com.flam.weathertrack.repository.WeatherRepository;

import java.util.List;

public class WeatherViewModel extends AndroidViewModel {

    private final WeatherRepository repository;
    private final LiveData<List<WeatherData>> last7Days;

    public WeatherViewModel(@NonNull Application application) {
        super(application);
        repository = new WeatherRepository(application);
        last7Days = repository.getLast7Days();
    }

    public LiveData<List<WeatherData>> getLast7Days() {
        return last7Days;
    }

    public void insert(WeatherData data) {
        repository.insert(data);
    }
}
