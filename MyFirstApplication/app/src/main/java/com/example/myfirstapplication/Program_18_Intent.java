/** Intent :-
 -------------
    The Android Intent is the message that is passed between components such as activities, content
 providers, broadcast receivers, services, etc

    It is generally used with "startActivity()" method to invoke activity, broadcast receivers, services, etc

    An intent is an abstract description of an operation to be performed. It can be used with "startActivity"
 to launch an "Activity", "broadcastIntent" to send it any interested "BroadcastReceiver" components and "Context.startService(Intent)" (or)
 "Context.bindService(Intent, serviceConnection, int)" to communicate with a background service.

    An intent provides a facility for performing late runtime binding between the code in different applications.
 It's most significant use is in the launching of activities, where it can be thought of as the give between activities.
 It is basically a passive data structure holding an abstract description of an action to be performed.

    The dictionary meaning of intent is intention (or) purpose. So it can be described as the intention to do action.

    The "Intent" class is available inside the "android.content" package. The "LabeledIntent" class
 is the subclass of "android.content.Intent" class.

    The Android Intents are mainly used to :-
 (i) Start the service
 (ii) Launch an activity
 (iii) Display a WebPage
 (iv) Display a list of contacts
 (v) Broadcast a message
 (vi) Dial a phone call , etc

    There are 2 types of intents. They are :- (i) Explicit Intent and (ii) Implicit Intent
 (i) Explicit Intent :-
 -----------------------
        The Android Explicit Intent specifies the component to be invoked from activity. In other words,
 we can call another activity in android by explicit intent. We can also pass the information from one
 activity to another using explicit intent. The explicit intent communicates between two activities
 inside the same applications.

 (ii) Implicit Intent :-
 -------------------------
        The Implicit Intent doesn't specify the component. In such case, the intents provides information
 of available components provided by the system that is to be invoked. The explicit intent communicates
 between two activities of different applications.

 SYNTAX :- Intent objectName = new Intent()
 Example :- Intent intent = new Intent()

 Public Constructors :-
 ------------------------
 1) Intent() :- It is used tio create an empty intent.
 2) Intent(Intent o) :- It is used to copy the constructors
 3) Intent(String action) :- It is used to create an intent with a given action.
 Parameter :- (i) action - The intent action such as "ACTION_VIEW".
 4) Intent(String action, Uri uri) :- It is used to create an intent with a given action and for the given data url
 Parameters :-
 (i) action - The intent action such as "ACTION_VIEW".
 (ii) uri - The intent data uri
 5) Intent(Context packageContext, Class<?>cls) :- It is used to create an intent for a specific component.
 Parameters :-
 (i) packageContext - A context of the application package implementing this class.
 (ii) cls - The component class that is to be used for the intent
 6) Intent(String action, Uri uri, Context packageContext, Class<?> cls) :- It is used to create an
 intent for a specific component with a specified action and data.
 Parameters :-
 (i) action - The Intent action, such as "ACTION_VIEW"
 (ii) uri - The intent data uri
 (iii) packageContext - A context of the application package implementing this class.
 (iv) cls - The component class that is to be used for the intent.

 Intent class declaration :-
 -------------------------------
    public class Intent extends Object implements Parcelable, Cloneable

 Intent Class Hierarchy :-
 ---------------------------
    java.lang.Object
    L> android.content.Intent
 **/
package com.example.myfirstapplication;

// Import the necessary packages
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;

import android.widget.EditText;
import android.widget.Button;

import android.view.View;
import android.view.View.OnClickListener;

public class Program_18_Intent extends AppCompatActivity implements OnClickListener {
    EditText username, emailAddress, phoneNumber, password;
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_18_intent);

        submitButton = findViewById(R.id.submit_to_second_activity);
        submitButton.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.submit_to_second_activity) {
            username = findViewById(R.id.username_edit_text);
            username.setHapticFeedbackEnabled(true);

            emailAddress = findViewById(R.id.email_address_edit_text);
            emailAddress.setHapticFeedbackEnabled(true);

            phoneNumber = findViewById(R.id.phone_number_edit_text);
            phoneNumber.setHapticFeedbackEnabled(true);

            password = findViewById(R.id.pass_word_edit_text);
            password.setHapticFeedbackEnabled(true);

            Intent intent = new Intent(getApplicationContext(), Intent_SecondActivity.class);
            intent.putExtra("username", username.getText().toString());
            intent.putExtra("email_address", emailAddress.getText().toString());
            intent.putExtra("phone_number", phoneNumber.getText().toString());
            intent.putExtra("password", password.getText().toString());

            startActivity(intent);
        }

    }
}