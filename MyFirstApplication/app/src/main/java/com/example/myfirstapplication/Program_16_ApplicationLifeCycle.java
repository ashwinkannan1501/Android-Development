package com.example.myfirstapplication;

// Import the necessary packages
import androidx.appcompat.app.AppCompatActivity; // Import the "AppCompatActivity" class from the "androidx.appcompat.app" package.

import android.os.Bundle; // Import the "Bundle" class form the "android.os" package

import android.widget.Toast; // Import the "Toast" class from the "android.widget" package.

public class Program_16_ApplicationLifeCycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_16_activity_life_cycle);

        String createActivity = "'onCreate()' method is activated. This method will create a application";
        Toast.makeText(this, createActivity, Toast.LENGTH_SHORT).show();
        System.out.println(createActivity);

    }

    @Override
    protected void onStart(){
        super.onStart();
        String startActivity = "'onStart()' method is activated. This method will start the application";
        Toast.makeText(this, startActivity, Toast.LENGTH_SHORT).show();
        System.out.println(startActivity);
    }

    @Override
    protected void onResume(){
        super.onResume();

        String resumeActivity = "'onResume()' method is activated. This method will resume the application";
        Toast.makeText(this, resumeActivity, Toast.LENGTH_SHORT).show();
        System.out.println(resumeActivity);
    }

    @Override
    protected void onPause(){
        super.onPause();

        String pauseActivity = "'onPause()' method is activated. This method will pause the application";
        Toast.makeText(this, pauseActivity, Toast.LENGTH_SHORT).show();
        System.out.println(pauseActivity);
    }

    @Override
    protected void onStop(){
        super.onStop();

        String stopActivity = "'onStop()' method is activated. This method will stop the application";
        Toast.makeText(this, stopActivity, Toast.LENGTH_SHORT).show();
        System.out.println(stopActivity);
    }

    @Override
    protected void onRestart(){
        super.onRestart();

        String restartActivity = "'onRestart()' method is activated. This method will restart the application";
        Toast.makeText(this, restartActivity, Toast.LENGTH_SHORT).show();
        System.out.println(restartActivity);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        String destroyActivity = "'onDestroy()' method is activated. This method will destroy the application";
        Toast.makeText(this, destroyActivity, Toast.LENGTH_SHORT).show();
        System.out.println(destroyActivity);
    }
}