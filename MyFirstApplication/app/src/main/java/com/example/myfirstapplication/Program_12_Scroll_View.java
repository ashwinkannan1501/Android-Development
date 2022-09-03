/** ScrollView :-
 -------------------
        Scroll view is a view which is used to scroll the view either horizontally (or) vertically.
 There are 2 types of scrollview :- 1) Vertical Scroll view and 2) Horizontal Scroll View

 1) Vertical Scroll View :-
 ----------------------------
        The "android.widget.ScrollView" class provides the functionality of the scroll view.
 Scroll View is used to scroll the child elements of palette inside scroll view. Android supports
 vertical scroll view as default scroll view. Vertical scroll view scrolls element vertically.

 2) Horizontal Scroll View :-
 ------------------------------
        The "Horizontal Scroll View" is a "FrameLayout". The "android.widget.HorizontalScrollView"
 class provides the functionality of horizontal scroll view. Horizontal Scroll View scrolls the child
 elements (or) views in a horizontal direction. Horizontal Scroll View only supports horizontal scrolling.
 **/
package com.example.myfirstapplication;

// Import the necessary packages
import androidx.appcompat.app.AlertDialog; // Import the "AlertDialog" class from the "androidx.appcompat.app" package which is used for showing alert dialog box to the user.
import androidx.appcompat.app.AppCompatActivity; // Import the "AppCompatActivity" class from the "androidx.appcompat.app" package.

import android.content.DialogInterface; // Import the "DialogInterface" class from the "android.content" package.

import android.graphics.Color;

import android.os.Bundle; // Import the "Bundle" class from the "android.os" package

import android.widget.EditText; // Import the "EditText" class from the "android.widget" package
import android.widget.Button; // Import the "Button" class from the "android.widget" package.

import android.view.View; // Import the "View" class from the
import android.view.View.OnClickListener;

public class Program_12_Scroll_View extends AppCompatActivity implements OnClickListener, DialogInterface.OnClickListener{
    EditText name, email, password, numericPassword, phoneNumber, time, date,address, comments, number, signedNumber, decimalNumber;
    Button submitButton;
    AlertDialog.Builder dialogBox, alertDialogBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_12_scroll_view); // Binding java file with xml file.

        name = findViewById(R.id.name_edit_text);
        email = findViewById(R.id.email_edit_text);
        password = findViewById(R.id.password_edit_text);
        numericPassword = findViewById(R.id.number_password_edit_text);
        phoneNumber = findViewById(R.id.phone_edit_text);
        time = findViewById(R.id.time_edit_text);
        date = findViewById(R.id.date_edit_text);
        address = findViewById(R.id.address_edit_text);
        comments = findViewById(R.id.multi_line_edit_text);
        number = findViewById(R.id.number_edit_text);
        signedNumber = findViewById(R.id.number_signed_edit_text);
        decimalNumber = findViewById(R.id.number_decimal_edit_text);

        submitButton = findViewById(R.id.submit);
        submitButton.setHapticFeedbackEnabled(true);
        submitButton.setOnClickListener(this::onClick);

        name.setTextColor(Color.BLUE); email.setTextColor(Color.BLUE); password.setTextColor(Color.BLUE);
        numericPassword.setTextColor(Color.BLUE); phoneNumber.setTextColor(Color.BLUE); time.setTextColor(Color.BLUE);
        date.setTextColor(Color.BLUE); address.setTextColor(Color.BLUE); comments.setTextColor(Color.BLUE);
        number.setTextColor(Color.BLUE); signedNumber.setTextColor(Color.BLUE); decimalNumber.setTextColor(Color.BLUE);
    }

    @Override
    public void onClick(View view){
        if (view.getId() == R.id.submit) {

            dialogBox = new AlertDialog.Builder(view.getContext());
            dialogBox.setTitle("User Information");
            dialogBox.setIcon(R.drawable.ashwin);
            dialogBox.setPositiveButton("Ok", this);

            dialogBox.setMessage(
                    "Name : " + name.getText().toString() + "\n" +
                    "Email Id : " + email.getText().toString() + "\n" +
                    "Password : " + password.getText().toString()+ "\n" +
                    "Numeric Password : " + numericPassword.getText().toString() + "\n" +
                    "Phone Number : " + phoneNumber.getText().toString() + "\n" +
                    "Date : " + date.getText().toString() + "\n" +
                    "Time : " + time.getText().toString() + "\n" +
                    "Address : " + address.getText().toString() + "\n" +
                    "Comments : " + comments.getText().toString() + "\n" +
                    "Number : " + number.getText().toString() + "\n" +
                    "Signed Number : " + signedNumber.getText().toString() + "\n" +
                    "Decimal Number : " + decimalNumber.getText().toString()
            );
            dialogBox.create();
            dialogBox.show();

            System.out.println("Name : " + name.getText().toString());
            System.out.println("Email Id : " + email.getText().toString());
            System.out.println("Password : " + password.getText().toString());
            System.out.println("Numeric Password : " + numericPassword.getText().toString());
            System.out.println("Phone Number : " + phoneNumber.getText().toString());
            System.out.println("Date : " + date.getText().toString());
            System.out.println("Time : " + time.getText().toString());
            System.out.println("Address : " + address.getText().toString());
            System.out.println("Comments : " + comments.getText().toString());
            System.out.println("Number : " + number.getText().toString());
            System.out.println("Signed Number : " + signedNumber.getText().toString());
            System.out.println("Decimal Number : " + decimalNumber.getText().toString());
        }
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int index){
        dialogInterface.cancel();
    }

    @Override
    public void onBackPressed() {
        System.exit(0);
    }

}
