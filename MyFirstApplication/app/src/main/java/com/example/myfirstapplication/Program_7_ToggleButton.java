/**  ToggleButton Component :-
 ---------------------------------
        The "ToggleButton" component can be used to display checked/unchecked (ON/OFF) state on the button.
 It is beneficial if the user have to change the setting between two states. It can be used to turn on/off sound, wifi, bluetooth, etc...
 Since android 4.0, there is another type of toggle button called switch that provides slider control to the user.

        Android ToggleButton are the subclasses of "CompoundButton" class. "ToggleButton" is available inside the "android.widget" package.

 ToggleButton class declaration :-
 ------------------------------------
        ----------------------------------------------------
        | public class ToggleButton extends CompoundButton |
        -----------------------------------------------------

 ToggleButton class hierarchy :-
 =================================
    java.lang.Object
    L> android.view.View
       L> android.widget.TextView
          L> android.widget.Button
             L> android.widget.CompoundButton
                L> android.widget.ToggleButton

 XML Attributes of ToggleButton class :-
 ------------------------------------------
 (i) android:disableAlpha :- The alpha to apply to the indicator when disabled
 (ii) android:textOff :- The text for the toggle button when it is turned off
 (iii) android:textOn :- The text for the toggle button when it is turned on.
 **/

package com.example.myfirstapplication;

// Import the necessary packages
import androidx.appcompat.app.AppCompatActivity; // Import the "AppCompatActivity" class from the "androidx.appcompat.app" package.
import androidx.constraintlayout.widget.ConstraintLayout; // Import the "ConstraintLayout" from the "androidx.constraintlayout.widget" package.

import android.os.Bundle; // Import the "Bundle" class from the "android.os" package.
import android.widget.TextView; // Import the "TextView" class from the "android.widget" package
import android.widget.ToggleButton; // Import the "ToggleButton" class from the "android.widget" package
import android.widget.Toast; // Import the "Toast" class from the "android.widget" package.

import android.graphics.Color; // Import the "Color" class from the "android.graphics" package

import android.widget.CompoundButton; // Import the "CompoundButton" class from the "android.widget" package
import android.widget.CompoundButton.OnCheckedChangeListener; // Import the "OnCheckedChangeListener" interface from the "android.widget.CompoundButton" class.

public class Program_7_ToggleButton extends AppCompatActivity implements OnCheckedChangeListener {
    ConstraintLayout constraintLayout;
    TextView textView, titleTextView;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_7_toggle_button);

        textView = findViewById(R.id.text_view_theme);
        titleTextView = findViewById(R.id.title_text_view);
        constraintLayout = findViewById(R.id.constraintLayout);
        toggleButton = findViewById(R.id.toggleButton);

        toggleButton.setOnCheckedChangeListener(this::onCheckedChanged);

        textView.setTextColor(Color.BLACK); textView.setBackgroundColor(Color.WHITE);
        titleTextView.setTextColor(Color.BLACK); titleTextView.setBackgroundColor(Color.WHITE);
        toggleButton.setTextColor(Color.BLACK); toggleButton.setBackgroundColor(Color.WHITE);
        constraintLayout.setBackgroundColor(Color.WHITE);

        // ToggleButton methods :-
        System.out.println("getAccessibilityClassName() method :- " + toggleButton.getAccessibilityClassName()); // This method is used to returns the class name of this object to be used for accessibility purposes.
        toggleButton.setTextOff("Dark mode"); // This method is used to sets the text of the toggle button when it is turned off.
        toggleButton.setTextOn("Light mode"); // This method is used to sets the text of the toggle button when it is turned on.
        toggleButton.setChecked(false); // This method is used to changes the checked state of the toggle button.
        System.out.println("getTextOn() method :- " + toggleButton.getTextOn()); // This method is used to return the text of the toggle button when it is turned on.
        System.out.println("getTextOff() method :- " + toggleButton.getTextOff()); // This method is used to return the text of the toggle button when it is turned off.
        //System.out.println("getDisabledAlpha() method :- " + toggleButton.getDisabledAlpha()); // This method is used to returns the alpha value of the toggle button when it is disabled
        System.out.println("isChecked() method :- " + toggleButton.isChecked()); // This method is used to checks whether the toggle button is turned on/off and returns true/false based on that.
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (compoundButton.getId() == R.id.toggleButton) {
            if (toggleButton.isChecked()) {
                textView.setText("Dark mode is turned on");
                textView.setTextColor(Color.WHITE);
                textView.setBackgroundColor(Color.BLACK);
                titleTextView.setTextColor(Color.WHITE); titleTextView.setBackgroundColor(Color.BLACK);

                constraintLayout.setBackgroundColor(Color.BLACK);

                toggleButton.setTextColor(Color.WHITE);
                toggleButton.setBackgroundColor(Color.BLACK);

                Toast.makeText(getApplicationContext(), "Dark mode is turned on", Toast.LENGTH_SHORT).show();
            } else if (! toggleButton.isChecked()){
                textView.setText("Light mode is turned on");
                textView.setTextColor(Color.BLACK);
                textView.setBackgroundColor(Color.WHITE);
                titleTextView.setTextColor(Color.BLACK); titleTextView.setBackgroundColor(Color.WHITE);

                constraintLayout.setBackgroundColor(Color.WHITE);

                toggleButton.setTextColor(Color.BLACK);
                toggleButton.setBackgroundColor(Color.WHITE);

                Toast.makeText(getApplicationContext(), "Light mode is turned on", Toast.LENGTH_SHORT).show();
            }
        }
    }
}