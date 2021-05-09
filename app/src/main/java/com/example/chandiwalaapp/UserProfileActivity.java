package com.example.chandiwalaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;

import com.example.chandiwalaapp.Fragment.AttendanceFragment;
import com.example.chandiwalaapp.Fragment.BlankFragment;


public class UserProfileActivity extends AppCompatActivity {
    TextView userName;
    ImageButton userDetailsImageButton;
    ImageButton attendanceImageButton;
    ConstraintLayout attendanceConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        userName = findViewById(R.id.userNameTextView);
        userDetailsImageButton = findViewById(R.id.userDetailsImageButton);
        attendanceImageButton = findViewById(R.id.attendanceImageButton);
        attendanceConstraintLayout = findViewById(R.id.attendanceConstraintLayout);
        userDetailsImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserDetailsActivity.class);
                startActivity(intent);

            }
        });

        attendanceImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AttendanceFragment attendanceFragment = new AttendanceFragment();
                BlankFragment blankFragment = new BlankFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.attendanceConstraintLayout, blankFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}