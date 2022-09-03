/** MULTIPLE LANGUAGE SUPPORT :-
 ---------------------------------
        Android is the most popular Operating System (OS) and it runs on millions of devices on many regions.
 So if we implement an android app which is localized for all regions, then it will reach the most of the users.
 Android consider "ENGLISH" is a default language but you can localize it.

        Android 7.0 (API level 24) provides support for multi-lingual users, allowing the users to select
 multiple locales in the setting. A "Locale" object represent a specific geographical, political (or)
 cultural region. Operations that required these locale to perform a tasks are called "locale-sensitive"
 and users to locale to tailor information to the users.
 **/

package com.example.myfirstapplication;

// Import the necessary packages
import androidx.appcompat.app.AppCompatActivity; // Import the "AppCompatActivity" class from the "androidx.appcompat.app" package.

import android.os.Bundle; // Import the "Bundle" class from the "android.os" package

import android.widget.Button; // Import the "Button" class from the "android.widget" package
import android.widget.Toast; // Import the "Toast"class from the "android.widget" package

import android.view.View; // Import the "View" class from the "android.view" package
import android.view.View.OnClickListener; // Import the "OnClickListener" interface from the "android.view.View" class.

public class Program_23_Support_Multiple_Languages extends AppCompatActivity implements OnClickListener{

    Button toastMessageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_23_multiple_languages_support);

        toastMessageButton = findViewById(R.id.toast_button);
        toastMessageButton.setHapticFeedbackEnabled(true);
        toastMessageButton.setClickable(true);

        toastMessageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if(view == toastMessageButton){
            Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show();
        }
    }
}