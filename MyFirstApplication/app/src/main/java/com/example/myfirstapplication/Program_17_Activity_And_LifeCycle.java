/** Activity and LifeCycle :-
 -------------------------------
        The "Activity and LifeCycle" is very much similar to "Application LifeCycle". The diagrams
 are exactly the same. The main difference is that

    1) When we move from one activity to another, the first activity "pauses and stops" and the second
 activity "creates, starts and resumes" and vice-versa.

    2) Due to "onDestroy()" method , when we move from one activity to another, the previously stored
 data in the older activity will be lost.

    3) When we rotate the screen from portrait to landscape (or) vice-versa, the data will be lost.
 **/

package com.example.myfirstapplication;

// Import the necessary packages
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;

public class Program_17_Activity_And_LifeCycle extends AppCompatActivity implements OnClickListener {
    Button secondActivityButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_17_activity_and_life_cycle);

        secondActivityButton = findViewById(R.id.second_activity_button);
        secondActivityButton.setOnClickListener(this::onClick);

        String createActivity = "'onCreate()' method is activated. This method will create a application";
        System.out.println("First Activity" + createActivity);
    }

    @Override
    protected void onStart(){
        super.onStart();
        String startActivity = "'onStart()' method is activated. This method will start the application";
        System.out.println("First Activity" + startActivity);
    }

    @Override
    protected void onResume(){
        super.onResume();

        String resumeActivity = "'onResume()' method is activated. This method will resume the application";
        System.out.println("First Activity" + resumeActivity);
    }

    @Override
    protected void onPause(){
        super.onPause();

        String pauseActivity = "'onPause()' method is activated. This method will pause the application";
        System.out.println("First Activity" + pauseActivity);
    }

    @Override
    protected void onStop(){
        super.onStop();

        String stopActivity = "'onStop()' method is activated. This method will stop the application";
        System.out.println("First Activity" + stopActivity);
    }

    @Override
    protected void onRestart(){
        super.onRestart();

        String restartActivity = "'onRestart()' method is activated. This method will restart the application";
        System.out.println("First Activity" + restartActivity);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        String destroyActivity = "'onDestroy()' method is activated. This method will destroy the application";
        System.out.println("First Activity" + destroyActivity);
    }


    @Override
    public void onClick(View view){
        if(view.getId() == R.id.second_activity_button){
            Intent intent = new Intent(getApplicationContext(), SecondActivity_Activity_And_LifeCycle.class);
            startActivity(intent);
        }
    }
}