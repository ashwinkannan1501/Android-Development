package com.example.myfirstapplication;

// Import the necessary packages
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ImageView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import android.view.View;
import android.view.View.OnClickListener;

public class Program_4_ImageView extends AppCompatActivity implements OnClickListener {

    EditText editText;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_4_image_view);

        Button button = findViewById(R.id.imageButton);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.imageButton) {
            editText = findViewById(R.id.editText);
            imageView = findViewById(R.id.imageView);
            if (editText.getText().toString().equals("")) {
                Toast.makeText(this, "Enter Person name to show their images", Toast.LENGTH_LONG).show();
                imageView.setImageResource(R.mipmap.ic_launcher);
            } else if(editText.getText().toString().equals("Tiger Shroff")) {
                imageView.setImageResource(R.drawable.tiger_shroff);
            } else if (editText.getText().toString().equals("Hrithik Roshan")) {
                imageView.setImageResource(R.drawable.hrithik_roshan);
            } else if (editText.getText().toString().equals("Vidyut Jamwal")) {
                imageView.setImageResource(R.drawable.vidyut_jamwal);
            } else if (editText.getText().toString().equals("Suriya")) {
                imageView.setImageResource(R.drawable.suriya);
            } else if (editText.getText().toString().equals("Tharun Kumar")) {
                imageView.setImageResource(R.drawable.tharun_kumar);
            } else if (editText.getText().toString().equals("Ashwin")) {
                imageView.setImageResource(R.drawable.ashwin);
            } else if (editText.getText().toString().equals("Ritika")) {
                imageView.setImageResource(R.drawable.ritika);
            } else if (editText.getText().toString().equals("Reshma")) {
                imageView.setImageResource(R.drawable.reshma);
            } else if (editText.getText().toString().equals("Kirthika")) {
                imageView.setImageResource(R.drawable.kirthika);
            } else if (editText.getText().toString().equals("Supriya")) {
                imageView.setImageResource(R.drawable.supriya);
            } else {
                Toast.makeText(this, "Name doesn't exists", Toast.LENGTH_SHORT).show();
                imageView.setImageResource(R.mipmap.ic_launcher_round);
            }
        }
    }
}