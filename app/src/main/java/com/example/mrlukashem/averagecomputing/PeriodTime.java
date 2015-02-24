package com.example.mrlukashem.averagecomputing;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MrLukashem on 2015-02-16.
 */
public class PeriodTime implements Parcelable {
    private String name;
    private List<Subject> subjectsList;

    PeriodTime(String __name) {
        subjectsList = new ArrayList<Subject>();
        name = new String(__name);
    }

    PeriodTime(String __name, ArrayList<Subject> __subjects_list) {
        subjectsList = new ArrayList<Subject>(__subjects_list);
        name = new String(__name);
    }

    PeriodTime(String __name, Subject[] __subjects) {
        subjectsList = new ArrayList<Subject>();
        for(Subject _subject : __subjects) {
            subjectsList.add(_subject);
        }

        name = __name;
    }

    Subject getSubject(int __index) {
        if(__index > 0 && __index < subjectsList.size())
            return subjectsList.get(__index);
        return null;
    }

    void setName(String __name) {
        name = new String(__name);
    }

    String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(subjectsList.size());
        for(Subject s : subjectsList)
            dest.writeParcelable(s, flags);
    }

    public static final Parcelable.Creator<PeriodTime> CREATOR
            = new Parcelable.Creator<PeriodTime>() {
        public PeriodTime createFromParcel(Parcel in) {
            return new PeriodTime(in);
        }

        public PeriodTime[] newArray(int size) {
            return new PeriodTime[size];
        }
    };

    private PeriodTime(Parcel in) {
        name = in.readString();

        subjectsList = new ArrayList<Subject>();
        for(int i = 0; i < in.readInt(); i++)
            subjectsList.add((Subject)in.readParcelable(Subject.class.getClassLoader()));
    }
}
