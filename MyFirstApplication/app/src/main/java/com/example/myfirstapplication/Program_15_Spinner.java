/** Android Spinner :-
  ---------------------
        The Android "Spinner" is a view similar to the dropdown list which is used to select one option
 from the list of options. It provides an easy way to select one item from the list of items and it shows
 a drop down list of all values when we click on it. The default value of the android spinner will be the
 currently selected value and by using adapter we can easily bind the items to the spinner objects. Generally
 we populate our spinner control with the list of items by using an "ArrayAdapter".

        The Android Spinner is like the combo-box of "AWT" (or) "Swing". It can be used to display the
 multiple options to the user in which user can select only one item from the list.

        The Spinner is associated with AdapterView, so you need to use one of the adapter classes with spinner.
 The "Spinner" class is the subclass of "AbsSpinner" class and the "Spinner" class is available inside the
 "android.widget" package.

 Spinner class declaration :-
 ------------------------------
    --------------------------------------------------------------------------------------
    | public class Spinner extends AbsSpinner implements DialogInterface.OnClickListener |
    --------------------------------------------------------------------------------------

 Spinner class hierarchy :-
 ----------------------------
    java.lang.Object
    L> android.view.View
       L> android.view.ViewGroup
          L> android.widget.AdapterView<android.widget.SpinnerAdapter>
             L> android.widget.AbsSpinner
                L> android.widget.Spinner

 Spinner Class Syntax :-
 -------------------------
    ---------------------------------------------------------
    | Spinner objectName = findViewById(R.id.spinnerIdName) |
    ---------------------------------------------------------

 Example :-
 -------------
    -------------------------------------------------
    | Spinner spinner = findViewById(R.id.spinner); |
    -------------------------------------------------

 XML Attributes :-
 ------------------
 1) android:id - It is used to specify the id of the view.
 2) android:textAlignment - It is used for the text alignment in the dropdown list.
 3) android:background - It is used to set the background color of the view.
 4) android:padding - It is used to set the padding of the view.
 5) android:visibility - It is used to set the visibility of the view.
 6) android:gravity - It is used to set the gravity of the view like "center", "top", "bottom" etc
 7) android:dropDownHorizontalOffset - It is used to set the amount of pixels by which the drop down should be offset horizontally.
 8) android:dropDownVerticalOffset - It is used to set the amount of pixels by which the drop down should be offset vertically.
 9) android:dropDownSelector - List selector to use for spinnerMode="dropdown" display.
 10) android:dropDownWidth - It is used to set the width of the drop down in spinnerMode="dropdown".
 11) android:popupBackground - It is used to set the background drawable to use for the dropdown in spinnerMode="dropdown".
 12) android:prompt - It is used to display the prompt when he spinner's dialog is shown
 13) android:spinnerMode - It is used to display the mode for spinner options.

 Constants :-
 --------------
 1) int MODE_DIALOG - Use a dialog window for selecting spinner options.
 2) nt MODE_DROPDOWN - Use a dropdown anchored to the spinner for selecting options.
 **/
package com.example.myfirstapplication;

// Import the necessary packages
import androidx.appcompat.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.icu.text.DateFormatSymbols;
import android.os.Bundle;

import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Program_15_Spinner extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    Spinner dateSpinner, monthSpinner, yearSpinner;
    Button submitButton;
    ArrayAdapter<String> dateArrayAdapter, monthArrayAdapter, yearArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_15_spinner);

        dateSpinner = findViewById(R.id.date_spinner);
        monthSpinner = findViewById(R.id.month_spinner);
        yearSpinner = findViewById(R.id.year_spinner);

        submitButton = findViewById(R.id.SubmitButton);
        submitButton.setOnClickListener(this);

        ArrayList<String> dateArrayList = new ArrayList<>(31);
        for (int index = 1; index <= 31; index += 1) {
            dateArrayList.add(String.valueOf(index) + "\n");
        }

        String[] months = new DateFormatSymbols().getMonths();

        ArrayList<String> yearArraylist = new ArrayList<String>();
        for(int year = 1990; year <= 2030; year += 1) {
            yearArraylist.add(String.valueOf(year) + "\n");
        }

        dateArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, dateArrayList);
        monthArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, months);
        yearArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, yearArraylist);

        dateArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // This method is used to set the layout resource to create the drop down views
        monthArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dateSpinner.setAdapter(dateArrayAdapter); // This method is used to sets the spinner adapter used to provide the data which backs this spinner.
        monthSpinner.setAdapter(monthArrayAdapter);
        yearSpinner.setAdapter(yearArrayAdapter);

        dateSpinner.setOnItemSelectedListener(this); // This method is used to perform an required specific action when the spinner item is clicked.
        monthSpinner.setOnItemSelectedListener(this);
        yearSpinner.setOnItemSelectedListener(this);

        // ArrayAdapter.createFromResource(this, android.R.array.emailAddressTypes, android.R.layout.simple_spinner_item); // This method is used to creates a new ArrayAdapter from external resources. The content of the array is obtained through "Resources.getTextArray(int)".
        dateSpinner.setEnabled(true); monthSpinner.setEnabled(true); yearSpinner.setEnabled(true); // This method is used to set the enabled state of this view. The interpretation of the enabled state varies by subclass.
        dateSpinner.setGravity(Gravity.CENTER); monthSpinner.setGravity(Gravity.CENTER); yearSpinner.setGravity(Gravity.CENTER); // This method is used to describes how the selected item view is positioned. Currently only the horizontal component is used. The default is determined by the current theme.
        dateSpinner.setPrompt("Date"); monthSpinner.setPrompt("Month"); yearSpinner.setPrompt("Year"); // This method is used to set the prompt to display when the dialog is shown.
        dateSpinner.setHapticFeedbackEnabled(true); monthSpinner.setHapticFeedbackEnabled(true); yearSpinner.setHapticFeedbackEnabled(true);
        dateSpinner.setDropDownHorizontalOffset(Spinner.MODE_DROPDOWN); monthSpinner.setDropDownHorizontalOffset(Spinner.MODE_DROPDOWN); yearSpinner.setDropDownHorizontalOffset(Spinner.MODE_DROPDOWN); // This method is used to set a horizontal offset in pixels for the spinner's popup window of choices.
        dateSpinner.setDropDownVerticalOffset(Spinner.MODE_DROPDOWN); monthSpinner.setDropDownVerticalOffset(Spinner.MODE_DROPDOWN); yearSpinner.setDropDownVerticalOffset(Spinner.MODE_DROPDOWN); // This method is used to set a vertical offset in pixels for the spinner's popup window of choices.
        dateSpinner.setDropDownWidth(300); monthSpinner.setDropDownWidth(300); monthSpinner.setDropDownWidth(300); // This method is used to set the width of the spinner's popup window of choices in pixels.
        dateSpinner.setPopupBackgroundResource(R.drawable.warning_toast); monthSpinner.setPopupBackgroundResource(R.drawable.success_toast); yearSpinner.setPopupBackgroundResource(R.drawable.info_toast); // This method is used to set the background drawable for the spinner's popup window of choices

        //System.out.println("performClick() method :- " + dateSpinner.performClick());
        System.out.println("getAccessibilityClassName() method :- "+ dateSpinner.getAccessibilityClassName()); // This method is used to return the class name of this object to be used for accessibility purposes.
        System.out.println("getBaseline() method :- " + dateSpinner.getBaseline()); // This method is used to return the offset of the widget's text baseline from the widget's top boundaries.
        System.out.println("getDropDownHorizontalOffset() method :- " + dateSpinner.getDropDownHorizontalOffset()); // This method is used to get the configured horizontal offset in pixels for the spinner's popup window of choices.
        System.out.println("getDropDownVerticalOffset() method :- " + dateSpinner.getDropDownVerticalOffset()); // This method is used to get the configured vertical offset in pixels for the spinner's popup window of choices.
        System.out.println("getDropDownWidth() method :- " + dateSpinner.getDropDownWidth()); // This method is used to get the configured width of the spinner's popup window of choices in pixels.
        System.out.println("getGravity() method :- " + dateSpinner.getGravity()); // This method is used to get the gravity of the spinner item
        System.out.println("getPopupBackground() method :- " + dateSpinner.getPopupBackground()); // This method is used to get the background drawable for the spinner's popup window of choices
        System.out.println("getPopupContext() method :- " + dateSpinner.getPopupContext()); // This method is used to return the pop up context for the spinner
        System.out.println("getPrompt() method :- " + dateSpinner.getPrompt()); // This method is used to get the prompt for the spinner.
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        String dateItem = dateArrayAdapter.getItem(i);
//        Toast.makeText(this, dateItem, Toast.LENGTH_SHORT).show();
//
//        String monthItem = monthArrayAdapter.getItem(i);
//        Toast tastyToast2 = TastyToast.makeText(this, monthItem, TastyToast.LENGTH_SHORT, TastyToast.WARNING);
//        tastyToast2.show();
//
//        String yearItem = yearArrayAdapter.getItem(i);
//        Toast tastyToast3 = TastyToast.makeText(this, yearItem, TastyToast.LENGTH_SHORT, TastyToast.CONFUSING);
//        tastyToast3.show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.SubmitButton){
            AlertDialog.Builder alertDialogBox = new AlertDialog.Builder(view.getContext());
            alertDialogBox.setTitle("Spinner Information");
            alertDialogBox.setMessage(
                    "Date :- " + dateSpinner.getSelectedItem().toString() +
                    "Month :- " + monthSpinner.getSelectedItem().toString() + "\n" +
                    "Year :- " + yearSpinner.getSelectedItem().toString()
            );
            alertDialogBox.setIcon(R.drawable.ashwin);
            alertDialogBox.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            alertDialogBox.create();
            alertDialogBox.show();
        }
    }
}