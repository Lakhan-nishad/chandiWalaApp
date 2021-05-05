package com.example.chandiwalaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText userNameEditText;
    EditText userPasswordEditText;
    FirebaseAuth auth;
    ImageButton loginImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameEditText = findViewById(R.id.userNameEditText);
        userPasswordEditText = findViewById(R.id.userPasswordEditText);
        loginImageButton = findViewById(R.id.loginImageButton);
        auth = FirebaseAuth.getInstance();
        loginImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameText = userNameEditText.getText().toString();
                String userPasswordText = userPasswordEditText.getText().toString();
                if (userNameText.isEmpty() || userPasswordText.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "userName or Password is empty!", Toast.LENGTH_SHORT).show();
                } else {
                    logIn(userNameText, userPasswordText);
                }
            }
        });
    }

    public void goToRegistrationPage(View view) {
        Toast.makeText(getApplicationContext(), "you are in registration page!", Toast.LENGTH_SHORT).show();
        finish();
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    private void logIn(String emailText, String PasswordText) {
        auth.signInWithEmailAndPassword(emailText, PasswordText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "LogIn Successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent = new Intent(getApplicationContext(), UserProfileActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong userName or Password!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}