/** Alert Dialog box :-
 -------------------------
        Alert Dialog shows the alert message and gives the answer in the form of yes (or) no. Alert
 Dialog displays the message to warn you and then according to your response, teh next step is proceed.

        Android Alert Dialog is built with the use of 3 fields :- Title, Message Area, Action Button.

        Then the 2 buttons, "PositiveButton", "NegativeButton" to our alert dialog box.

        The "android.app.AlertDialog.Builder" class is the subclass of "java.lang.Object".
 The "AlertDialog.Builder" class is available inside the "android.app" package.

 Alert Dialog class declaration :-
 -------------------------------------
        ----------------------------------------------------------
        | public static class AlertDialog.Builder extends Object |
        ----------------------------------------------------------

 Alert Dialog class Hierarchy :-
 ---------------------------------
     ----------------------------------------
     |  java.lang.Object                    |
     |  L> android.app.AlertDialog.Builder  |
     ----------------------------------------

 Public Constructors :-
 ------------------------
 1) AlertDialog.Builder(Context context) :- This constructor is used to create a builder for an alert dialog that uses the default alert dialog theme.
 2) AlertDialog.Builder(Context context, int themeResId) :- This constructor is used to create a builder for an alert dialog that uses an explicit theme resource.
 **/
package com.example.myfirstapplication;

// Import the necessary packages
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;


public class Program_11_AlertDialog extends AppCompatActivity {
    AlertDialogBox alertDialogBox;
    Button exitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_11_alert_dialog);

        exitButton = findViewById(R.id.exit_button);

        alertDialogBox = new AlertDialogBox();
        alertDialogBox.alertDialog(exitButton);

    }

    @Override
    public void onBackPressed(){
        alertDialogBox.onClick(exitButton);
    }
}

class AlertDialogBox implements OnClickListener, DialogInterface.OnClickListener{
    AlertDialog.Builder alertDialogBox;
    protected void alertDialog(Button exitButton) {
        exitButton.setHapticFeedbackEnabled(true);

        exitButton.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view){
        if (view.getId() == R.id.exit_button) {
            alertDialogBox = new AlertDialog.Builder(view.getContext()); // This Constructor is used to create a builder for an alert dialog box that uses the default alert dialog theme.

            // Public Methods for "AlertDialog.Builder" class
            alertDialogBox.setTitle("Exit"); // This method is used to set the title displayed in the dialog.
            alertDialogBox.setMessage("Are you really want to quit from this application ? 🤔🤔"); // This method is used to set the message to display the given resource id (or) text.
            alertDialogBox.setIcon(R.drawable.ashwin); // This method is used to set the drawable to be used in the title.
            alertDialogBox.setPositiveButton("Yes, I want to quit", this::onClick); // This method is used to set a listener to be invoked when the positive button of the dialog is pressed.
            alertDialogBox.setNegativeButton("No, I want to continue", this::onClick); // This method is used to set the listener to be invoked when the negative button of the dialog is pressed.
            alertDialogBox.setNeutralButton("This is the neutral button", this::onClick); // This method is used to set a listener to be invoked when the neutral button of the dialog uis pressed.
            alertDialogBox.setOnCancelListener(DialogInterface::cancel); // This method is used to set the callback that will be called if teh dialog box is cancelled.
            alertDialogBox.setOnDismissListener(DialogInterface::dismiss); // This method is used to set the callback that will be called when the dialog is dismissed for any reasons.
            //alertDialogBox.setOnItemSelectedListener(AdapterView.OnItemSelectedListener listener) :- This method is used to set a listener to be invoked when an item in the list is selected
            //alertDialogBox.setOnKeyListener(DialogInterface.OnKeyListener onKeyListener); // This method is used to set the callback that will be called if a key is dispatched to the dialog.
            //alertDialogBox.setView(view); // This method is used to set a custom view to be the contents of the alert dialog.
            alertDialogBox.setCancelable(true); // This method is used to set whether the alert dialog box is cancelable or not. Default is true.
            //alertDialogBox.setAdapter(ListAdapter adapter, DialogInterface.OnClickListener listener); // This method is used to set a list of items, which are supplied by the given list adapter, to be displayed in the dialog  as the content, you will be notified of the selected item via the supplied listener.
            // alertDialogBox.setCursor(Cursor cursor, DialogInterface.OnClickListener listener, String labelColumn); // This method is used to set a list of items, which are supplied by the given cursor, to be displayed in the dialog as the content, you will be notified of the selected item via the supplied listener.
            // alertDialogBox.setCustomTitle(view); // This method is used to set the title using the custom view "customTitleView".
            //alertDialogBox.setIconAttribute(R.attr.targetId); // This method is used to set an icon as supplied by a theme attribute (eg) R.attr.alertDialogItem
            CharSequence[] items = {"Yes, I want to quit", "No, I want to continue", "This is the neutral button"};
            alertDialogBox.setItems(items, this::onClick); // This method is used to display a set of items in the dialog as the content, you will be notified of the selected item via the supplied listener. This should be an array type. (i.e) R.array.foo.

            alertDialogBox.create(); // This method is used to creates an alert dialog box with the arguments supplied to this builder. Calling this method does not display the dialog.
            alertDialogBox.show(); // This method is used to creates an alert dialog box with the arguments supplied to this builder and immediately displays the dialog.

            System.out.println("getContext() method :- " + alertDialogBox.getContext()); // This method is used to return a context with the appropriate theme for dialog created by this builder.

        }
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if(i == AlertDialog.BUTTON_POSITIVE){
            System.exit(0);
        } else if (i == AlertDialog.BUTTON_NEGATIVE){
            dialogInterface.cancel(); // This method is used to cancel/dismiss the dialog box.
        } else if (i == AlertDialog.BUTTON_NEUTRAL) {
            System.out.println("The Neutral button is pressed");
        }
    }

}