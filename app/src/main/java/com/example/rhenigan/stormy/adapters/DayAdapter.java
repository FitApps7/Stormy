package com.example.rhenigan.stormy.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rhenigan.stormy.R;
import com.example.rhenigan.stormy.weather.Day;

/**
 * Created by henig on 4/17/2018.
 * ------------------------------
 */
public class DayAdapter extends RecyclerView.Adapter<DayAdapter.DayViewHolder> {

    private Day[] mDays;

    public DayAdapter(Day[] days) {
        mDays = days;
    }

    public class DayViewHolder extends RecyclerView.ViewHolder {

        public TextView mDayNameLabel;
        public TextView mTempLabel;
        public ImageView mIconImageView;
        public ImageView mCircleImageView;


        public DayViewHolder(View itemView) {
            super(itemView);

            mDayNameLabel = itemView.findViewById(R.id.dayNameLabel);
            mTempLabel = itemView.findViewById(R.id.tempLabel);
            mIconImageView = itemView.findViewById(R.id.iconImageView);
            mCircleImageView = itemView.findViewById(R.id.circleImageView);
        }

        public void bindDay(Day day) {
            mDayNameLabel.setText(day.getDay());
            mTempLabel.setText(day.getTempMax() + "");
            mIconImageView.setImageResource(day.getIconId());
            mCircleImageView.setImageResource(R.drawable.clear_day);
        }
    }

    @Override
    public DayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_list_item, parent, false);
        DayViewHolder viewHolder = new DayViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DayViewHolder holder, int position) {
        holder.bindDay(mDays[position]);
    }

    @Override
    public int getItemCount() {
        return mDays.length;
    }
}
