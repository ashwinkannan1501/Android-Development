package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.content.Intent;

import android.view.View;
import android.view.View.OnClickListener;

public class SecondActivity_Activity_And_LifeCycle extends AppCompatActivity implements OnClickListener {
    Button firstActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_application_and_life_cycle);

        firstActivityButton = findViewById(R.id.first_activity_button);
        firstActivityButton.setOnClickListener(this::onClick);

        String createActivity = "'onCreate()' method is activated. This method will create a application";
        System.out.println("Second Activity" + createActivity);
    }

    @Override
    protected void onStart(){
        super.onStart();
        String startActivity = "'onStart()' method is activated. This method will start the application";
        System.out.println("Second Activity" + startActivity);
    }

    @Override
    protected void onResume(){
        super.onResume();

        String resumeActivity = "'onResume()' method is activated. This method will resume the application";
        System.out.println("Second Activity" + resumeActivity);
    }

    @Override
    protected void onPause(){
        super.onPause();

        String pauseActivity = "'onPause()' method is activated. This method will pause the application";
        System.out.println("Second Activity" + pauseActivity);
    }

    @Override
    protected void onStop(){
        super.onStop();

        String stopActivity = "'onStop()' method is activated. This method will stop the application";
        System.out.println("Second Activity" + stopActivity);
    }

    @Override
    protected void onRestart(){
        super.onRestart();

        String restartActivity = "'onRestart()' method is activated. This method will restart the application";
        System.out.println("Second Activity" + restartActivity);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        String destroyActivity = "'onDestroy()' method is activated. This method will destroy the application";
        System.out.println("Second Activity" + destroyActivity);
    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.first_activity_button){
            Intent intent = new Intent(getApplicationContext(), Program_17_Activity_And_LifeCycle.class);
            startActivity(intent);
        }
    }
}