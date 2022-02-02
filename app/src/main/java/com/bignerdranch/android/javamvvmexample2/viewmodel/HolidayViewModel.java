package com.bignerdranch.android.javamvvmexample2.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bignerdranch.android.javamvvmexample2.model.HolidayModel;
import com.bignerdranch.android.javamvvmexample2.repo.HolidayRepo;

import java.util.List;

public class HolidayViewModel extends ViewModel {

    private HolidayRepo holidayRepo;
    private MutableLiveData<List<HolidayModel>> mutableLiveData;

    public HolidayViewModel() {
        holidayRepo = new HolidayRepo();
    }

    public LiveData<List<HolidayModel>> getHolidays() {
        if(mutableLiveData == null) {
            mutableLiveData = holidayRepo.requestHolidays();
        }

        return mutableLiveData;
    }
}