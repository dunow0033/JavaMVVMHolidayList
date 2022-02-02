package com.bignerdranch.android.javamvvmexample2.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bignerdranch.android.javamvvmexample2.R;
import com.bignerdranch.android.javamvvmexample2.adapter.HolidayAdapter;
import com.bignerdranch.android.javamvvmexample2.databinding.ActivityMainBinding;
import com.bignerdranch.android.javamvvmexample2.model.HolidayModel;
import com.bignerdranch.android.javamvvmexample2.viewmodel.HolidayViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    final String TAG = getClass().getSimpleName();
    ActivityMainBinding binding;
    HolidayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.rvHolidayListing.setHasFixedSize(true);

        binding.rvHolidayListing.setLayoutManager(new LinearLayoutManager(this));

        adapter = new HolidayAdapter();
        binding.rvHolidayListing.setAdapter(adapter);
        binding.progressBar.setVisibility(View.VISIBLE);

        HolidayViewModel holidayViewModel = new HolidayViewModel();

        holidayViewModel.getHolidays().observe(this, new Observer<List<HolidayModel>>() {
            @Override
            public void onChanged(List<HolidayModel> holidayModels) {
                if(holidayModels != null && !holidayModels.isEmpty()) {
                    Log.d("now", "here");
                    binding.progressBar.setVisibility(View.GONE);
                    adapter.addHolidayList(holidayModels);
                    adapter.notifyDataSetChanged();
                }
            }
        });

    }
}