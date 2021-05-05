package com.example.chandiwalaapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.chandiwalaapp.AttendanceAdapter;
import com.example.chandiwalaapp.R;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AttendanceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AttendanceFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ListView attendanceListView;
    String[] keys;
    Map<String, String> attendanceMark;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AttendanceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment attendanceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AttendanceFragment newInstance(String param1, String param2) {
        AttendanceFragment fragment = new AttendanceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_attendance, container, false);
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
        AttendanceAdapter attendanceAdapter = new AttendanceAdapter(getContext(), R.layout.attendance_layout, keys, attendanceMark);
        attendanceListView.setAdapter(attendanceAdapter);

        return view;
    }
}