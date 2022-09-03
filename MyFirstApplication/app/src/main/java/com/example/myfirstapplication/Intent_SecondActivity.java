package com.example.myfirstapplication;

// Import the necessary packages
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.widget.TextView;
import android.content.Intent;

public class Intent_SecondActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_second_activity);

        TextView username = findViewById(R.id.getting_username_text_view);
        TextView emailAddress = findViewById(R.id.getting_email_address_text_view);
        TextView phoneNumber = findViewById(R.id.getting_phone_number_text_view);
        TextView password = findViewById(R.id.getting_password_text_view);

        Intent intent = getIntent();

        String getUsername = intent.getStringExtra("username");
        String getEmailAddress = intent.getStringExtra("email_address");
        String getPhoneNumber = intent.getStringExtra("phone_number");
        String getPassword = intent.getStringExtra("password");

        username.setText("Username : " + getUsername);
        emailAddress.setText("Email Address : " + getEmailAddress);
        phoneNumber.setText("Phone Number : " + getPhoneNumber);
        password.setText("Password : " + getPassword);
    }

}