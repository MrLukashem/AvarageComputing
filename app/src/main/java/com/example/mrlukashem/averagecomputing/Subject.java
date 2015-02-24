package com.example.mrlukashem.averagecomputing;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MrLukashem on 2015-02-16.
 */

public class Subject implements Parcelable {
    private int weight;
    private double grade;
    private String name;

    public Subject(int __weight, double __grade, String __name) {
        weight = __weight;
        grade = __grade;
        name = __name;
    }

    void setWeight(int __weight) {
        if(weight > 0)
            weight = __weight;
    }

    void setGrade(double __grade) {
        if(grade > 1.0 && grade <= 6.0)
            grade = __grade;
    }

    void setName(String __name) {
        if(!__name.isEmpty())
            name = __name;
    }

    int getWeight() {
        return weight;
    }

    double getGrade() {
        return grade;
    }

    String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel __dest, int __flags) {
        __dest.writeInt(weight);
        __dest.writeDouble(grade);
        __dest.writeString(name);
    }

    private void readFromParcel(Parcel in) {
        weight = in.readInt();
        grade = in.readDouble();
        name = in.readString();
    }

    public static final Parcelable.Creator<Subject> CREATOR
            = new Parcelable.Creator<Subject>() {
        public Subject createFromParcel(Parcel in) {
            return new Subject(in);
        }

        public Subject[] newArray(int size) {
            return new Subject[size];
        }
    };

    private Subject(Parcel in) {
        weight = in.readInt();
        grade = in.readDouble();
        name = in.readString();
    }
}