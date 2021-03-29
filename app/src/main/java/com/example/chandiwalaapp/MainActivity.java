package com.example.chandiwalaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeActivity(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "you are in registration page!", Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }
}