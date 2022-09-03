/** EditText Component :-
 -------------------------
        The "EditText" component is one of the basic UI widget, which is used to take the input from the user.
 The EditText is derived or is the extension of the text view android. The EditText class is similar to
 "JTextField", "JTextArea" and "JPasswordField" classes in swing.

        The "EditText" class is found inside the "android.widget" package.

 EditText class declaration :-
 --------------------------------
        ------------------------------------------
        | public class EditText extends TextView |
        ------------------------------------------

 EditText class hierarchy :-
 ------------------------------
        java.lang.Object
        L> android.view.View
           L> android.widget.TextView
              L> android.widget.EditText

 Input Type for the EditText component :-
 ------------------------------------------
 1) Number - Mathematical numeric value
 2) Phone - Contact number based on country code
 3) Date - To take the date input
 4) Time - To take the time input
 5) TextCapCharacter - To take the entire input in the upper case characters
 6) TextMultiLine - Makes the user input multiple lines of text
 7) TextEmailAddress - To take the email address from the user.
 8) TextPersonName - To take the nam of the person as input.
 9) TextPassword - To take the text password from the user, which turns into asterisks (.) dots after entering the data.
 10) NumberPassword - To take only the number digits as a password.
 11) TextVisiblePassword - To take the text password from the user, which do not turns into asterisks dots after entering the data.
 12) TextURI - To take the particular URL of the website.

 EditText Methods :-
 ---------------------
 1) void extendSelection(int index) :- This method is used to move the selection edge to the offset index.
 2) CharSequence getAccessibilityClassName() :- This method is used to return the class name of this object to be used for accessibility purposes.
 3) boolean getFreezesText() :- This method is used to returns true if the edit text including its entire text content in frozen icicles, otherwise false. For EditText it always returns true.
 4) Editable getText() :- This method is used to returns the text in the EditText.
 5) void selectAll() :- This method is used to select all the text in the edit text.
 6) void setEllipsize(TextUtils.TruncateAt ellipsis) :- This method cause words in the text that are longer than the view's width to be ellipsized instead of broken in the middle.
 7) void setSelection(int start, int stop) :- This method is used to set the selection anchor to "start" and the selection edge to "stop".
 8) void setSelection(int index) :- This method is used to set the cursor selection to index position.
 9) void setText(CharSequence text, TextView.BufferType type) :- This method is used to set the text to be displayed in the specified edit text.
 **/
package com.example.myfirstapplication;

// Import the necessary packages
import androidx.appcompat.app.AppCompatActivity; // Import the "AppCompatActivity" class from the "androidx.appcompat.app" package
import android.os.Bundle; // Import the "Bundle" class from "android.os" package
import android.view.View; // Import the "View" class from the "android.view" package
import android.widget.EditText; // Import the "EditText" class from the "android.widget" package.
import android.widget.Button; // Import the "Button" class from  the "android.widget" package.

public class Program_3_EditText extends AppCompatActivity {
        private EditText nameEditText, ageEditText, phoneNumberEditText, emailAddressEditText, dateEditText, timeEditText, passwordEditText, postalAddressEditText;
        private Button button;

        @Override
        protected void onCreate(Bundle savedInstanceState){
                super.onCreate(savedInstanceState);
                setContentView(R.layout.program_3_edit_text);

                nameEditText = findViewById(R.id.name);
                ageEditText = findViewById(R.id.age);
                phoneNumberEditText = findViewById(R.id.phone_number);
                emailAddressEditText = findViewById(R.id.email_address);
                dateEditText = findViewById(R.id.date);
                timeEditText = findViewById(R.id.time);
                passwordEditText = findViewById(R.id.password);
                postalAddressEditText = findViewById(R.id.postal_address);

                button = findViewById(R.id.submit_button);
                //nameEditText.setText("Hello My Friend");

                button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                String name = nameEditText.getText().toString();
                                String age = ageEditText.getText().toString();
                                String phoneNumber = phoneNumberEditText.getText().toString();
                                String emailAddress = emailAddressEditText.getText().toString();
                                String date = dateEditText.getText().toString();
                                String time = timeEditText.getText().toString();
                                String password = passwordEditText.getText().toString();
                                String postalAddress = postalAddressEditText.getText().toString();

                                System.out.println("------- Printing Information ---------");
                                System.out.println("Name : " + name);
                                System.out.println("Age : " + age);
                                System.out.println("Phone Number : " + phoneNumber);
                                System.out.println("Email Address : " + emailAddress);
                                System.out.println("Date : " + date);
                                System.out.println("Time : " + time);
                                System.out.println("Password : " + password);
                                System.out.println("Address : " + postalAddress);

                                nameEditText.extendSelection(nameEditText.getText().length() - 1);
                                nameEditText.selectAll();
                                System.out.println("getAccessibilityClassName() method : " + nameEditText.getAccessibilityClassName());
                                System.out.println("getFreezesText() method : " + nameEditText.getFreezesText());
                                //nameEditText.setEllipsize();
                                nameEditText.setSelection(0, 5);
                        }
                });
       }
}