package com.example.chandiwalaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Map;

public class AttendanceAdapter extends ArrayAdapter<String> {

    Map<String, String> attendanceMarks;
    public String[] keys;

    public AttendanceAdapter(@NonNull Context context, int resource, @NonNull String[] keys) {
        super(context, resource, keys);
        this.keys = keys;
        //this.attendanceMarks = attendanceMarks;

    }


    @Nullable
    @Override
    public String getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.attendance_layout, parent, false);
        TextView dateTextView = convertView.findViewById(R.id.dateTextView);
        //TextView dateProgressTextView = convertView.findViewById(R.id.dateProgressTextView);
        dateTextView.setText(keys[position]);
        //dateProgressTextView.setText(attendanceMarks.get(keys[position]));
        return super.getView(position, convertView, parent);
    }
}
