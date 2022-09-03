package com.example.myfirstapplication;

// Import the necessary packages
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import de.hdodenhof.circleimageview.CircleImageView;
import android.widget.Button;

import android.content.Intent;

import android.view.View;
import android.view.View.OnClickListener;

public class Program_19_ImplicitIntent_FirstActivity extends AppCompatActivity implements OnClickListener {

    CircleImageView circleImageView;
    Button uploadButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_19_implicit_intent);

        circleImageView = findViewById(R.id.circlural_image_view);
        uploadButton = findViewById(R.id.choose_a_photo_from_gallery_button);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.choose_a_photo_from_gallery_button) {
            Intent implicitIntent = new Intent(Intent.ACTION_GET_CONTENT);
            Intent uri = implicitIntent.setType("image/*");
            startActivity(implicitIntent);
            //circleImageView.setImageResource(uri.getData());
        }
    }

}