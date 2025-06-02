package com.flam.weathertrack.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.*;

import com.flam.weathertrack.R;
import com.flam.weathertrack.viewmodel.WeatherViewModel;
import com.flam.weathertrack.data.model.WeatherData;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WeatherViewModel viewModel;
    private RecyclerView recyclerView;
    private WeatherAdapter adapter; // You can create a basic adapter or leave this part out for now

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new WeatherAdapter(); // Or skip for now
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(WeatherViewModel.class);

        viewModel.getLast7Days().observe(this, data -> {
            if (data != null) {
                adapter.setData(data); // Skip if adapter not ready
            }
        });
    }
}
