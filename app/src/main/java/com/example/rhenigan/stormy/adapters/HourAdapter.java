package com.example.rhenigan.stormy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rhenigan.stormy.R;
import com.example.rhenigan.stormy.weather.Hour;

/**
 * Created by henig on 4/16/2018.
 * ------------------------------
 */
public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder> {

    private Hour[] mHours;
    private Context mContext;

    public HourAdapter(Context context, Hour[] hours) {
        mHours = hours;
        mContext = context;
    }

    public class HourViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mTimeLabel;
        public TextView mSummaryLabel;
        public TextView mTempLabel;
        public ImageView mIconImageView;

        public HourViewHolder(View itemView) {
            super(itemView);

            mTimeLabel = itemView.findViewById(R.id.timeLabel);
            mSummaryLabel = itemView.findViewById(R.id.summaryLabel);
            mTempLabel = itemView.findViewById(R.id.tempLabel);
            mIconImageView = itemView.findViewById(R.id.iconImageView);

            itemView.setOnClickListener(this);
        }

        public void bindHour(Hour hour) {
            mTimeLabel.setText(hour.getHour());
            mSummaryLabel.setText(hour.getSummary());
            mTempLabel.setText(hour.getTemp() + "");
            mIconImageView.setImageResource(hour.getIconId());
        }

        @Override
        public void onClick(View view) {
            String Time = (String) mTimeLabel.getText();
            String Temp = (String) mTempLabel.getText();
            String Summary = (String) mSummaryLabel.getText();
            String message = String.format("At %s it will be %s and %s", Time, Temp, Summary);
            Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hourly_list_item, parent, false);
        HourViewHolder viewHolder = new HourViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HourViewHolder holder, int position) {
        holder.bindHour(mHours[position]);
    }

    @Override
    public int getItemCount() {
        return mHours.length;
    }
}
