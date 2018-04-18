package com.example.rhenigan.stormy.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by henig on 4/9/2018.
 * ------------------------------
 */

public class Day implements Parcelable {

    private Long mTime;
    private String mSummary;
    private double mTempMax;
    private String mIcon;
    private String mTimeZone;

    public Day() {}

    public Long getTime() {
        return mTime;
    }

    public void setTime(Long time) {
        mTime = time;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public double getTempMax() {
        return (int) Math.round(mTempMax);
    }

    public void setTempMax(double tempMax) {
        mTempMax = tempMax;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getTimeZone() {
        return mTimeZone;
    }

    public void setTimeZone(String timeZone) {
        mTimeZone = timeZone;
    }

    public int getIconId() {
        return Forecast.getIconId(mIcon);
    }

    public String getDay() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
        Date date = new Date(mTime*1000);
        return formatter.format(date);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(mTime);
        parcel.writeString(mSummary);
        parcel.writeDouble(mTempMax);
        parcel.writeString(mIcon);
        parcel.writeString(mTimeZone);
    }

    public Day(Parcel in) {
        mTime = in.readLong();
        mSummary = in.readString();
        mTempMax = in.readDouble();
        mIcon = in.readString();
        mTimeZone = in.readString();
    }

    public static final Creator<Day> CREATOR = new Creator<Day>() {
        @Override
        public Day createFromParcel(Parcel parcel) {
            return new Day(parcel);
        }

        @Override
        public Day[] newArray(int i) {
            return new Day[i];
        }
    };
}
