package com.example.rhenigan.stormy.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by henig on 4/9/2018.
 * ------------------------------
 */

public class Hour implements Parcelable {

    private long mTime;
    private String mSummary;
    private double mTemp;
    private String mIcon;
    private String mTimezone;

    public Hour() {}

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public void setTemp(double temp) {
        mTemp = temp;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getTimezone() {
        return mTimezone;
    }

    public void setTimeZone(String timezone) {
        mTimezone = timezone;
    }

    public int getIconId() {
        return Forecast.getIconId(mIcon);
    }

    public int getTemp() {
        return (int) Math.round(mTemp);
    }

    public String getHour() {
        SimpleDateFormat formatter = new SimpleDateFormat("h a");
        Date date = new Date(mTime *1000);
        return formatter.format(date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(mTime);
        parcel.writeDouble(mTemp);
        parcel.writeString(mSummary);
        parcel.writeString(mIcon);
        parcel.writeString(mTimezone);
    }

    private Hour(Parcel in) {
        mTime = in.readLong();
        mTemp = in.readDouble();
        mSummary = in.readString();
        mIcon = in.readString();
        mTimezone = in.readString();
    }

    public static final Creator<Hour> CREATOR = new Creator<Hour>() {
        @Override
        public Hour createFromParcel(Parcel parcel) {
            return new Hour(parcel);
        }

        @Override
        public Hour[] newArray(int i) {
            return new Hour[i];
        }
    };


}
