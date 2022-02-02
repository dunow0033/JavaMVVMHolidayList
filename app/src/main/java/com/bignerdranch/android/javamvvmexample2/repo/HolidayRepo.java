package com.bignerdranch.android.javamvvmexample2.repo;

import androidx.lifecycle.MutableLiveData;

import com.bignerdranch.android.javamvvmexample2.model.HolidayModel;
import com.bignerdranch.android.javamvvmexample2.retrofit.ApiInterface;
import com.bignerdranch.android.javamvvmexample2.retrofit.RetrofitUtility;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HolidayRepo {

    private final String TAG = getClass().getSimpleName();

    public MutableLiveData<List<HolidayModel>> requestHolidays() {
        final MutableLiveData<List<HolidayModel>> mutableLiveData = new MutableLiveData<>();

        ApiInterface apiService = RetrofitUtility.getRetrofitClient().create(ApiInterface.class);

        apiService.getHolidays().enqueue(new Callback<List<HolidayModel>>() {
            @Override
            public void onResponse(Call<List<HolidayModel>> call, Response<List<HolidayModel>> response) {
                if(response.isSuccessful() && response.body() != null) {
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<HolidayModel>> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }


}
