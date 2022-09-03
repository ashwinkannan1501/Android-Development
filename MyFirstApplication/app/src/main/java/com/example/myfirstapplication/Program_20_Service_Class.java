package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Program_20_Service_Class extends AppCompatActivity implements View.OnClickListener{
    protected Button startMusic, stopMusic;
    protected Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_20_servie_class);

        startMusic = findViewById(R.id.start_music_service_button);
        startMusic.setOnClickListener(this);

        stopMusic = findViewById(R.id.stop_music_service_button);
        stopMusic.setOnClickListener(this);

        intent = new Intent(this, Services.class);
    }

    @Override
    public void onClick(View view) {
        if(view == startMusic){
            startService(intent);
            Toast.makeText(this, "Music Starts Playing", Toast.LENGTH_SHORT).show();
        } else if (view == stopMusic) {
            Toast.makeText(this, "Music Stops Playing", Toast.LENGTH_SHORT).show();
            stopService(intent);
        }
    }
}