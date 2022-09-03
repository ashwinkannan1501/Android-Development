/** CheckBox Component :-
 -------------------------
    The  "CheckBox" component is a type of two-state button either checked or unchecked. There are lot of usage of checkboxes.
 For example :- it can be used to know the hobby of the user, activate/deactivate teh specific action etc.
 Android "CheckBox" is a subclass of "CompoundButton" class.

    The CheckBox is used to turn an option "ON"(true) (or) "OFF"(false). Clicking on the checkbox
 changes it's state from "ON" to "OFF" and from "OFF" to "ON". It inherits "CompoundButton" class.

    The "CheckBox" class is similar to "JCheckBox" class in swing. The "CheckBox" class is available inside the "android.widget" package.

 CheckBox class declaration :-
 -------------------------------
    ------------------------------------------------
    | public class CheckBox extends CompoundButton |
    ------------------------------------------------

 CheckBox class hierarchy :-
 ------------------------------
    java.lang.Object
    L> android.view.View
       L> android.widget.TextView
          L> android.widget.Button
             L> android.widget.CompoundButton
                L> android.widget.CheckBox

 CheckBox Methods :-
 ---------------------
        There are many inherited methods of "View", "TextView" and "Button" classes in the CheckBox class. Mainly used methods are :-
 1) CharSequence getAccessibilityClassName() :- This method used to returns the class name of the object to be used for accessibility purposes.
 2) boolean isChecked() :- This method is used to returns true if it is checked, otherwise false.
 3) void setChecked(boolean status) :- This method is used to change the state of the checkbox.

 **/
package com.example.myfirstapplication;

// Import the necessary packages
import androidx.appcompat.app.AppCompatActivity; // Import the "AppCompatActivity" class from the "androidx.appcompat.app" package

import android.os.Bundle; // Import the "Bundle" class from "android.os" package

import android.graphics.Color; // Import the "Color" class from the "android.graphics" package

import android.widget.TextView; // Import the "TextView" class from the "android.widget" package
import android.widget.CheckBox; // Import the "CheckBox" class from the "android.widget" package
import android.widget.Button; // Import the "Button" class from  the "android.widget" package.
import android.widget.Toast; // Import the "Toast" class from the "android.widget" package.

import android.view.View; // Import the "View" class from the "android.view" package
import android.view.View.OnClickListener; //Import the  "OnClickListener" interface from the "android.view.View" class.

public class Program_5_CheckBox extends AppCompatActivity implements OnClickListener {
    private TextView textView;
    private CheckBox agreementCheckBox;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_5_check_box);

        textView = findViewById(R.id.descriptionTextView);
        textView.setText(
                "A Terms and Conditions agreement is the agreement that includes the terms," +
                        "the rules and the guidelines of acceptable behavior and other useful " +
                        "sections to which users must agree in order to use or access your website and mobile app."
        );
        textView.setTextColor(Color.BLACK);

        agreementCheckBox = findViewById(R.id.checkBox);
        agreementCheckBox.setText("I agree to the following terms and conditions");
        agreementCheckBox.setTextColor(Color.BLACK);
        agreementCheckBox.setOnClickListener(this::onClick);

        button = findViewById(R.id.downloadButton);
        button.setEnabled(false);
        button.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        if(agreementCheckBox.getId() == R.id.checkBox) {
            if (agreementCheckBox.isChecked()) {
                button.setEnabled(true);
            } else if (! agreementCheckBox.isChecked()){
                button.setEnabled(false);
            }
        } else if (button.getId() == R.id.downloadButton) {
            Toast.makeText(getApplicationContext(), "Starting download", Toast.LENGTH_LONG).show();
        }
    }
}