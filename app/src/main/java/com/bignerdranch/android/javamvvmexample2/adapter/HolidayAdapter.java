package com.bignerdranch.android.javamvvmexample2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bignerdranch.android.javamvvmexample2.R;
import com.bignerdranch.android.javamvvmexample2.databinding.ItemHolidayBinding;
import com.bignerdranch.android.javamvvmexample2.model.HolidayModel;

import java.util.ArrayList;
import java.util.List;

public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.MyViewHolder> {

    private List<HolidayModel> holidayList;

    public HolidayAdapter() {
        holidayList = new ArrayList<>();
    }

    public void addHolidayList(List<HolidayModel> cList) {
        this.holidayList = cList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHolidayBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_holiday, parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.binding.setModel(holidayList.get(position));
    }

    @Override
    public int getItemCount() {
        return holidayList != null ? holidayList.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ItemHolidayBinding binding;

        public MyViewHolder(ItemHolidayBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
