package com.example.chandiwalaapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.chandiwalaapp.AttendanceAdapter;
import com.example.chandiwalaapp.R;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class AttendanceFragment extends Fragment {

    ListView attendanceListView;
    String[] keys;
    Map<String, String> attendanceMark;

    public AttendanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_attendance, container, false);
//        attendanceListView = view.findViewById(R.id.attendanceListView);
//        attendanceMark = new LinkedHashMap<>();
//        attendanceMark.put("5/4/2021", "status: (p)");
//        attendanceMark.put("6/4/2021", "status: (p)");
//        attendanceMark.put("7/4/2021", "status: (p)");
//        attendanceMark.put("8/4/2021", "status: (p)");
//        attendanceMark.put("9/4/2021", "status: (p)");
//        keys = new String[attendanceMark.size()];
//        int i = 0;
//        for (Map.Entry<String, String> stringStringEntry : attendanceMark.entrySet()) {
//            keys[i] = stringStringEntry.getKey();
//            i++;
//        }
//        AttendanceAdapter attendanceAdapter = new AttendanceAdapter(getContext(), R.layout.attendance_layout, keys, attendanceMark);
//        attendanceListView.setAdapter(attendanceAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        attendanceListView = view.findViewById(R.id.attendanceListView);
        attendanceMark = new LinkedHashMap<>();
        attendanceMark.put("5/4/2021", "status: (p)");
        attendanceMark.put("6/4/2021", "status: (p)");
        attendanceMark.put("7/4/2021", "status: (p)");
        attendanceMark.put("8/4/2021", "status: (p)");
        attendanceMark.put("9/4/2021", "status: (p)");
        keys = new String[attendanceMark.size()];
        int i = 0;
        for (Map.Entry<String, String> stringStringEntry : attendanceMark.entrySet()) {
            keys[i] = stringStringEntry.getKey();
            i++;
        }
        AttendanceAdapter attendanceAdapter = new AttendanceAdapter(getActivity(), R.layout.attendance_layout, keys);
        attendanceListView.setAdapter(attendanceAdapter);

    }
}