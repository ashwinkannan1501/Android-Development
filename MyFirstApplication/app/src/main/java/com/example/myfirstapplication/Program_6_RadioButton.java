/** --------------------------- RadioGroup and RadioButton ------------------------
 RadioGroup :-
 ----------------
    The "RadioGroup" class is used to create a multiple-exclusion scope for a set of radio button.
 Checking one radio button that belongs to a radio group unchecks any previously checked radio button within the same group.

    Initially, all the radio buttons are unchecked. While it is not possible to uncheck a particular
 radio button, the radio group can be cleared to remove the checked state.

    The selection is identified by the unique id of the radio button s defined in the xml layout file.
 The "RadioGroup" class in android concept is very much similar to "ButtonGroup" in swing concept.

    The "RadioGroup" class is inherited from the "LinearLayout" class.
 The "RadioGroup" class is found inside the "android.widget" package.

 RadioGroup class declaration :-
 -------------------------------------
        ------------------------------------------------
        | public class RadioGroup extends LinearLayout |
        ------------------------------------------------

 RadioGroup class hierarchy :-
 -------------------------------
    java.lang.Object
    L> android.view.View
       L> android.view.ViewGroup
          L> android.widget.LinearLayout
             L> android.widget.RadioGroup

 RadioGroup public methods :-
 ------------------------------
 1) void addView(View child, int index, ViewGroup.LayoutParams params) :-
 ---------------------------------------------------------------------------
        The "addView()" method is used to add the child view with the specified layout parameters.
 Parameters :-
 ---------------
    (i) child - The child view to add
    (ii) index - The position at which to add the child (or) -1 to add last
    (iii) params - The layout parameters to set on the child.

 2) void autofill(AutofillValue value) :-
 ------------------------------------------
        The "autofillValue() method is used to automatically fills the content of this view with the value.
 Parameters :- (i) value - The value to be auto-filled."

 3) void check(int id) :-
 ----------------------------
        The "check()" method is used to sets the selection to the radiobutton whose identifier is
 passed in parameter. Using -1 as the selection identifier, clears the selection.
 Parameter :- (i) id - The unique id of the radiobutton to select in this group.

 4) void clearCheck() :- The "clearCheck()" method is used to clears the selection. When the selection is cleared, no radiobutton in this group is selected.

 5) RadioGroup.LayoutParams generateLayoutParams (AttributeSet attrs) :-
 ------------------------------------------------------------------------
        The "generateLayoutParams()" method is used to returns a new set of layout parameters based on the supplied attribute set.
 Parameter :- (i) attrs - the attributes to build the layout parameters from

 6) CharSequence getAccessibilityClassName() :-
 ------------------------------------------------
        The "getAccessibilityClassName()" method is used to returns the class name of the object to be used for accessibility purposes.

 7) int getAutofillType() :- The "getAutofillType()" method is used to return teh autofill type of this view.

 8) AutofillValue getAutofillValue() :- This method is used to get/return the view's current autofill value. By default, it returns null, but sub-classes should override it and return an appropriate value to properly support the autofill framework.

 9) int getCheckedRadioButtonId() :- This method is used to returns the identifier(integer) of the selected radio button in this group. Upon empty selection, the returned value is -1.

 10) void setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener) :-
 ----------------------------------------------------------------------------
        The "setOnCheckedChangeListener()" method is used to generate a callback to be invoked when the checked radio button changes in this group.
 Parameter :- (i) listener - The callback to call on checked state change.

 11) void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener listener) :-
 -----------------------------------------------------------------------------------------
        The "setOnHierarchyChangeListener()" method is used to register a callback to be invoked when a child is added to (or) removed from this view.
 Parameter :- (i) listener - The callback to invoke on hierarchy change.

 RadioButton :-
 ----------------
        The "RadioButton" class is a widget which can have more than one option to choose from. The user can choose only one option at a time.
 Each option here refers to a radio button and all the options for the topic are together referred to as a radio group.
 Hence, radio buttons are used inside the radio group.

        The "RadioButton" class is used to create a radiobutton. It is used to choose one option from multiple options.
 It is widely used in exam systems or quiz. It should be added in RadioGroup to select one radio button only.

        The "RadioButton" class is available inside the "android.widget" package. The "RadioButton" and "RadioGroup" in android
 is very much similar to the "JRadioButton" and "ButtonGroup" in swing.

 RadioButton class declaration :-
 -----------------------------------
        ---------------------------------------------------
        | public class RadioButton extends CompoundButton |
        ---------------------------------------------------

 RadioButton class hierarchy :-
 ---------------------------------
    java.lang.Object
    L> android.view.View
       L> android.widget.TextView
          L> android.widget.Button
             L> android.widget.CompoundButton
                L> android.widget.RadioButton

 RadioButton methods :-
 ------------------------
 1) void toggle() :- This method is used to change the checked state of the view to the inverse of it's current state. If the radio button is already checked, this method will not toggle the radio button.
 2) CharSequence getAccessibilityClassName() :- This method is used to return the class name of the object to be used for accessibility purposes.
 3) void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) :- This method is used to initialize an accessibility node info with information about this view.
 Parameter :- (i) info - The instance to initialize.
 4) boolean isChecked() method :- This method is used to returns true/false based on the radio button is selected (or) not.
 **/
package com.example.myfirstapplication;

// Import the necessary packages
import androidx.appcompat.app.AppCompatActivity; // Import the "AppCompatActivity" class from the "androidx.appcompat.app" package.

import android.os.Bundle; // Import the "Bundle" class from the "android.os" package

import android.widget.ImageView; // Import the "ImageView" class from the "android.widget" package.
import android.widget.RadioGroup; // Import the "RadioGroup" class from the "android.widget" package.
import android.widget.RadioButton; // Import the "RadioButton" class from the "android.widget" package.
import android.widget.Button; // Import the "Button" class from the "android.widget" package
import android.widget.Toast; // Import the "Toast" class from the "android.widget" package.

import android.view.View; // Import the "View" class from the "android.view" package
import android.view.View.OnClickListener; // Import the "OnClickListener" interface from the "android.view.View" class.

import android.widget.CompoundButton; // Import the "CompoundButton" class from the "android.widget" package.
import android.widget.CompoundButton.OnCheckedChangeListener; // Import the "OnCheckedChangeListener" interface from the "android.widget.CompoundButton" class.

public class Program_6_RadioButton extends AppCompatActivity implements OnClickListener, OnCheckedChangeListener {
    private ImageView genderImageView;
    private RadioGroup radioGroup;
    private RadioButton maleRadioButton;
    private RadioButton femaleRadioButton;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_6_radio_button);

        genderImageView = findViewById(R.id.genderImageView);
        radioGroup = findViewById(R.id.radioGroup);
        maleRadioButton = findViewById(R.id.maleRadioButton);
        maleRadioButton.setOnCheckedChangeListener(this::onCheckedChanged);

        femaleRadioButton = findViewById(R.id.femaleRadioButton);
        femaleRadioButton.setOnCheckedChangeListener(this::onCheckedChanged);

        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(this::onClick);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked){
        if (compoundButton.getId() == R.id.maleRadioButton) {
            if (maleRadioButton.isChecked()) {
                genderImageView.setImageResource(R.drawable.ashwin);
                //Toast.makeText(this, "You are a male", Toast.LENGTH_SHORT).show();
            }
        } else if (compoundButton.getId() == R.id.femaleRadioButton) {
            if (femaleRadioButton.isChecked()) {
                genderImageView.setImageResource(R.drawable.reshma);
                //Toast.makeText(this, "You are a female", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.submitButton) {
            if (maleRadioButton.isChecked()) {
                genderImageView.setImageResource(R.drawable.ashwin);
                Toast.makeText(this, "You are a male", Toast.LENGTH_SHORT).show();
            } else if (femaleRadioButton.isChecked()) {
                genderImageView.setImageResource(R.drawable.reshma);
                Toast.makeText(this, "You are a female", Toast.LENGTH_SHORT).show();
            }
        }
    }
}