package com.example.chandiwalaapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegistrationActivity extends AppCompatActivity {

    Button submitButton;
    EditText firstName;
    EditText lastName;
    EditText phoneNumber;
    EditText email;
    EditText address;
    private EditText password;
    private EditText confirmPassword;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ragistration);
        submitButton = findViewById(R.id.submitButton);
        firstName = findViewById(R.id.nameEditText);
        lastName = findViewById(R.id.lastNameEditText);
        phoneNumber = findViewById(R.id.phoneEditText);
        email = findViewById(R.id.emailAddressEditText);
        address = findViewById(R.id.addressEditText);
        password = findViewById(R.id.passwordEditText);
        confirmPassword = findViewById(R.id.confirmPasswordEditText);
        auth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("user");
        submitButton.setOnClickListener(v -> {
            String emailText = email.getText().toString();
            String passwordText = password.getText().toString();
            String confirmPasswordText = confirmPassword.getText().toString();
            if (TextUtils.isEmpty(emailText) || TextUtils.isEmpty(passwordText)) {
                Toast.makeText(getApplicationContext(), "empty credential!", Toast.LENGTH_SHORT).show();
            } else if (!passwordText.equals(confirmPasswordText)) {
                Toast.makeText(getApplicationContext(), "confirmed password is not matched with password!", Toast.LENGTH_SHORT).show();
            } else if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                email.setError("email address is not valid!");
            } else {
                final int[] flag = {0};
                auth.fetchSignInMethodsForEmail(emailText).addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<SignInMethodQueryResult>() {
                    @Override
                    public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                        if (!task.getResult().getSignInMethods().isEmpty()) {
                            flag[0] = 1;
                            Toast.makeText(getApplicationContext(), "this email already exist!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                if (flag[0] == 0) {
                    registerUser(emailText, passwordText);
                }
            }
        });
    }

    private void registerUser(String emailText, String passwordText) {
        String userNameText = firstName.getText().toString() + " " + lastName.getText().toString();
        String phoneNumberText = phoneNumber.getText().toString();
        String addressText = address.getText().toString();
        auth.createUserWithEmailAndPassword(emailText, passwordText).addOnCompleteListener(RegistrationActivity.this, task -> {
            if (task.isSuccessful()) {
                firebaseUser = auth.getCurrentUser();
                UserDetails userDetails = new UserDetails(userNameText, phoneNumberText, emailText, addressText);
//                Toast.makeText(getApplicationContext(), "Registration 200 Successfully.", Toast.LENGTH_SHORT).show();
                // we have to also care about position of toast and other.
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.child(firebaseUser.getUid()).setValue(userDetails);
                        Toast.makeText(getApplicationContext(), "Registration Successfully.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getApplicationContext(), "fail to data add!.", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Toast.makeText(getApplicationContext(), "Registration Failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}