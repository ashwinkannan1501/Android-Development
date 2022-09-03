/** SharedPreferences Classes :-
 ----------------------------------
        One of the most interesting data storage option Android provides it's users is "SharedPreferences" class.
 SharedPreferences is the way in which one can store and retrieve small amount of primitive data as
 "key/value" pairs to a file on the device storage such as "String", "int", "float", "Boolean" that
 make up your preferences in an xml file inside the app on teh device storage. SharedPreferences can
 be thought as a "dictionary" (or) "key/value" pair.

        For example, you might have a key being “username” and for the value, you might store the user’s
 username. And then you could retrieve that by its key (here username). You can have a simple shared
 preference API that you can use to store preferences and pull them back as and when needed. Shared
 Preferences class provides APIs for reading, writing, and managing this data.

        Shared Preferences are suitable in different situations. For Example, when the user's settings
 need to be saved (or) to store data that can be used in different activities within the app. As you
 know, "onPause()" method will always be called before your activity is placed in the background (or)
 destroyed. So, for the data to be saved persistently, it's preferred to save it in "onPause()" method,
 which could be restored in "onCreate()" method of the activity. The data stored using shared preferences
 are kept private within the scope of the application. However, shared preferences are different from
 that activity's instance state.

 How to create shared preferences ? :-
 ----------------------------------------
        The first thing we need to do is to create one shared preferences file per app. So, name it
 with the package of your app - unique and easy to associate with the app. When you want to get the
 values, call the "getSharedPreferences()" method. Shared Preferences provides modes of storing the
 data (public and private mode). It is for backward compatibility - use only "MODE_PRIVATE" to be secure.

 public abstract SharedPreferences getSharedPreferences(String name, int mode) :-
 ------------------------------------------------------------------------------------
        The "getSharedPreferences()" method takes two arguments. The first being the "SharedPreference
 file name" and other is the "Context mode" that we want to store our file in. There are 6 modes. They are :-

 (1) MODE_PRIVATE :- By setting this mode, the file can only be accessed using calling application. This mode keeps the files private and secures the user's data.
 (2) MODE_APPEND :- This mode will append the new preferences with the already existing preferences. It is used while reading teh data from the SP file.
 (3) MODE_ENABLE_WRITE_AHEAD_LOGGING :- Database open flag. When it is set, it would enable write ahead logging by default.
 (4) MODE_MULTI_PROCESS :- This mode will check for the modification of preferences even if the shared preference instance has already been loaded.
 (5) MODE_WORLD_READABLE :- This mode will allow other application to read the preferences.
 (6) MODE_WORLD_WRITEABLE :- This mode will allow other application to write the preferences.

 SharedPreferences Interface Declaration :-
 -----------------------------------------------
        --------------------------------------
        | public interface SharedPreferences |
        --------------------------------------
    The "SharedPreferences" interface is available in "android.content" package. "import android.content.SharedPreferences"

 Nested Classes of SharedPreferences :-
 -----------------------------------------
 1) SharedPreferences.Editor :- Interface used to write(edit) data in the SP file. Once editing has been done, one must "commit()" (or) "apply()" the changes made to the file.
 2) SharedPreferences.OnSharedPreferenceChangeListener :- Called when a shared preference is changed, added (or) removed. This may be called even if a preference is set to it's existing value. This callback will be run on your main thread.

 -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

 SharedPreferences.Editor class :-
 ------------------------------------
    You can save something in the shared preferences by using "SharedPreferences.Editor" class. You will
 call the "edit()" method of shared preference instance and will receive it an editor object.

 SharedPreferences.Editor class declaration :-
 ------------------------------------------------
    public static interface SharedPreference.Editor

    The "SharedPreferences.Editor" interface is available in the "android.content" package.
    "import android.content.SharedPreferences.Editor"
  **/
package com.example.myfirstapplication;

// Import the necessary packages
import androidx.appcompat.app.AppCompatActivity; // Import the "AppCompatActivity" class from the "androidx.appcompat.app" package.

import android.content.Context; // Import the "Context" class from the "android.content" package
import android.os.Bundle; // Import the "Bundle" class from the "android.os" package.

import android.widget.CheckBox; // Import the "CheckBox" class from the "android.widget" package
import android.widget.EditText; // Import the "EditText" class from the "android.widget" package
import android.widget.Button; // Import the "Button" class from the "android.widget" package

import android.view.View; // Import the "View" class from the "android.view" package
import android.view.View.OnClickListener; // Import the "OnClickListener" interface from the "android.view.View" class
import android.widget.Toast; // Import the "Toast" class from the "android.widget" package

import android.content.SharedPreferences; // Import the "SharedPreferences" class from the "android.content" package.

public class Program_22_SharedPreferences_Class extends AppCompatActivity implements OnClickListener{

    private EditText usernameEditText, passwordEditText;
    private CheckBox rememberMeCheckBox;
    private Button loginButton;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private String username, password;
    private boolean isChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_22_shared_preferences_class);

        usernameEditText = findViewById(R.id.user_name_edit_text);
        passwordEditText = findViewById(R.id.password_editText);
        rememberMeCheckBox = findViewById(R.id.remember_me_checkbox);
        loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(this);

        onRetrieveData();

    }

    @Override
    public void onClick(View view){
        if(view == loginButton) {
            if((usernameEditText.getText().toString().equals("")) || (passwordEditText.getText().toString().equals(""))){
                Toast.makeText(this, "Username and Password must not be empty", Toast.LENGTH_SHORT).show();
            } else if((usernameEditText.getText().toString().equals("ashwinkannan1501@gmail.com")) && (passwordEditText.getText().toString().equals("ashwinkannanamutha"))){
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        onSaveData();
        super.onDestroy();
    }


    private void onSaveData(){
        sharedPreferences = getSharedPreferences("Saving Data", Context.MODE_PRIVATE); // The "getSharedPreferences()" method is used to get/return the shared preferences object. The name of the SP should be passed as a parameter.
        editor = sharedPreferences.edit(); // The "edit()" method is used to crate a new editor for these preferences, tghrough which you can make modifications to the data in the preferences and atomically commit those changes back to the SP object. Note that you must call the "commit()" method to have changes you perform in the editor actually show up in the SP. It must returns a new instance of the editor interface, allowing you to modify the values in the SP object.

        username = usernameEditText.getText().toString();
        password = passwordEditText.getText().toString();
        isChecked = rememberMeCheckBox.isChecked();

        // SharedPreferences methods :-
        System.out.println("contains() method :- " + sharedPreferences.contains("username")); // This method is used to checks whether a preferences contains a preference. Returns true if the preference exists in the preferences, otherwise false.
        System.out.println("getAll() method :- " + sharedPreferences.getAll()); // This method is used to retrieve all the values from the preferences. It returns a map containing a list of "key/value" pairs representing the preferences. Note that you must not modify the collection returned by this method, or alter any of it's contents. The consistency of your stored data is not guaranteed if you do.


        if(rememberMeCheckBox.isChecked()){
            // putString() method :- This method is used to set a string value in the preferences editor, to be written back once "commit()" (or) "apply()" method are called. This takes a "key" and a "value" as a parameter.
            // putBoolean() method :- This method is used to set a boolean value in the preferences editor, to be written back once "commit()" (or) "apply()" method are called. This takes a "key" and a "value" as a parameter.
            // putFloat() method :- This method is used to set a float value in the preferences editor, to be written back once "commit()" (or) "apply()" method are called. This takes a "key" and a "value" as a parameter.
            // putInt() method :- This method is used to set a integer value in the preferences editor, to be written back once "commit()" (or) "apply()" method are called. This takes a "key" and a "value" as a parameter.
            // putLong() method :- This method is used to set a long value in the preferences editor, to be written back once "commit()" (or) "apply()" method are called. This takes a "key" and a "value" as a parameter.
            // putStringSet() method :- This method is used to set a array of strings value in the preferences editor, to be written back once "commit()" (or) "apply()" method are called. This takes a "key" and a "value" as a parameter.

            editor.putString("username", username);
            editor.putString("password", password);
            editor.putBoolean("checkbox", isChecked);

            editor.apply(); // This method is used to commit your preferences changes back from this editor to the SP object it is editing.
            System.out.println("commit() method :- " + editor.commit()); // This method is exactly the same as "apply()" method. It returns true if the new values were successfully written o persistent storage
            // editor.clear(); // This method is used to remove all the values from the preferences.
            // editor.remove(String key); // This method is used to remove the value whose key has been passed as a parameter once "commit()" method is called.

            Toast.makeText(this, "Your data is saved", Toast.LENGTH_SHORT).show();
        }

    }

    private void onRetrieveData(){
        sharedPreferences = getSharedPreferences("Saving Data", Context.MODE_PRIVATE);

        // getBoolean() method :- This method is used to retrieve a boolean value from the preferences. It returns a preferences value if it's exists (or) default value.
        // getFloat() method :- This method is used to retrieve a float value from the preferences. It returns a preferences value if it's exists (or) default value.
        // getInt() method :- This method is used to retrieve a integer value from the preferences. It returns a preferences value if it's exists (or) default value.
        // getLong() method :- This method is used to retrieve a long value from the preferences. It returns a preferences value if it's exists (or) default value.
        // getString() method :- This method is used to retrieve a string value from the preferences. It returns a preferences value if it's exists (or) default value.
        // getStringSet() method :- This method is used to retrieve a set of strings array value from the preferences. It returns a preferences value if it's exists (or) default value.

        username = sharedPreferences.getString("username", null);
        password = sharedPreferences.getString("password", null);
        isChecked = sharedPreferences.getBoolean("checkbox", false);
        //sharedPreferences.registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener); // This method is used to registers a callback to be invoked when a change happens to a preference.
        //sharedPreferences.unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener);// This method is used to unregister a previous callback.

        usernameEditText.setText(username);
        passwordEditText.setText(password);
        rememberMeCheckBox.setChecked(isChecked);

    }

}