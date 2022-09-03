/** TextView Component :-
 -------------------------
        A "TextView" component displays text to the user and optionally allows them to edit it.
 A TextView is a complete text editor, however the basic class is configured to not allow editing.
 It inherits "View" class. It is similar to "JLabel" component in "Swing" concept. The "TextView" class
 is available inside the "android.widget" package.

 TextView class declaration :-
 --------------------------------
        ------------------------------------------------------------------------------------
        | public class TextView extends View implements ViewTreeObserver.OnPreDrawListener |
        ------------------------------------------------------------------------------------

 TextView class Hierarchy :-
 -----------------------------
    java.lang.Object
    L>  android.view.View
        L>  android.widget.TextView

 **/
package com.example.myfirstapplication;

// Import the necessary packages
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView; // The "TextView" class is available inside the "android.widget" package

public class Program_1_TextView extends AppCompatActivity{

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_1_text_view);

        textView = findViewById(R.id.textView);
        textView.append("\n 😍😍"); // This method is used to set the text (append) at the end of the existing text in the text view.
        textView.setTextSize(40.0F);
        System.out.println("length() method : " + textView.length());
        textView.setOnClickListener(new OnClickListener() { // This method is used to register the click on the text view and performing an required action.
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View view) {
                // Methods :-
                // textView.append("Appending the text to the end"); // This method is used to set the text at the end of the existing text in the text view.
                // textView.append("Appending the text to the end", 0, (int)textView.getTextSize()-1);

                textView.setText("I am an android developer now.... 😁😁"); // This method is used to sets the text to be displayed on the text view.
                textView.setHeight(50); // This method is used to sets the height of the text view to be exactly pixels tall.
                textView.setWidth(100); // This method is used to sets teh width of ten text view to be exactly pixels wide.
                textView.setAllCaps(true); // This method is used to set the text to be all uppercase letters.
                textView.setBackgroundColor(Color.BLACK); // This method is used to sets the color of the background of the text view component for all the states (normal, selected and focused)
                textView.setTextColor(Color.WHITE); // This method is used to sets the color of the text for all the states (normal, selected and focused).
                textView.setTextSize(20.0F); // This method is used to sets the default text size to the given value, interpreted as "scaled pixel" units. The size is adjusted based on the current density and user font size preference.
                textView.setCursorVisible(false); // This method is used to set the boolean value for the cursor visibility on the text view
                textView.setEnabled(true); // This method is used to sets the enabled state of the text view. The interpretation of the enabled state varies by subclass.
                textView.setGravity(Gravity.CENTER); // This method is used to sets the horizontal alignment of the text and the vertical gravity that will be used when there is an extra space in the text view beyond what is required for the text itself.
                textView.setSelected(true); // This method is use dto changes the selection state of the text view. A text view can be selected or not. Note that the selection is not the same as the focus.
                textView.setHighlightColor(Color.GREEN); // This method is used to set the color used to display the selection highlight.
                textView.setHint("This is the hint of the textview when the textview is empty"); // This method is used to sets the text to be displayed when the text of the text view is empty. Null means to use the normal empty text.
                textView.setHintTextColor(Color.WHITE); // This method is used to set the color of the hint text for all the states (disabled, focused, selected) of the text view.
                textView.setHorizontallyScrolling(true); // This method is used to set whether the text should be allowed to be wider than text view. If false, it will be wrapped to the width of the text view.
                textView.setIncludeFontPadding(true); // This method is used to set whether the text view includes extra top and bottom padding. The default is 'true'

                System.out.println("getText() method :  " + textView.getText().toString()); // This method is used to returns the text that text view displays.
                System.out.println("getFocusable() method : " + textView.getFocusable()); // This method is used to returns true/false based on the text view is focusable or not.
                System.out.println("getHeight() method : " + textView.getHeight()); // This method is used to returns the height of the text view.
                System.out.println("getWidth() method : " + textView.getWidth()); // This method is used to returns the width of the text view.
                System.out.println("getGravity() method : " + textView.getGravity()); // This method is used to returns the inter gravity alignment value.
                System.out.println("getTextSize() method : " + textView.getTextSize()); // This method is used to returns the size of the text of the text view.
                System.out.println("getCurrentTextColor() method : " + textView.getCurrentTextColor()); // This method is used to returns teh current color selected for the normal text of the text view.
                System.out.println("getHighlightColor() method : " + textView.getHighlightColor()); // This method is used to return the highlight color integer value of the text view.
                System.out.println("getHint() method : " + textView.getHint()); // This method is used to returns the hint that is displayed when the text of the text view is empty.
                System.out.println("getCurrentHintTextColor() method : " + textView.getCurrentHintTextColor()); // This method is used to returns teh current hint text color of the text view.
                System.out.println("getIncludeFontPadding() method : " + textView.getIncludeFontPadding()); // This method is used to returns the boolean value for font padding in the text view.
                System.out.println("getBackground() method :- " + textView.getBackground());
                System.out.println("getFontFeatureSettings() method :- " + textView.getFontFeatureSettings());

                System.out.println("length() method : " + textView.length()); // This method is used to returns the length of the text in the text view.

                System.out.println("isAllCaps() method : " + textView.isAllCaps()); // This method is used to returns the boolean value depending upon teh text in the text view is uppercase or not.
                System.out.println("isCursorVisible() method  : " + textView.isCursorVisible()); // This method is used to returns the boolean value depending upon the cursor is visible or not in the text view.
                System.out.println("isSelected() method : " + textView.isSelected()); // This method is used to returns the boolean value depending upon the text is selected or not
                System.out.println("isTextSelectable() method : " + textView.isTextSelectable()); // This method is used to return the boolean value depending upon the text is selectable or not.
                System.out.println("isSuggestionsEnabled() method : " + textView.isSuggestionsEnabled()); // This method is used to returns the boolean value depending upon the suggestions is enabled or not.

                System.out.println("hasSelection() method : " + textView.hasSelection()); // This method is used to returns true if there is a selection of non-zero length inside the text view.

                // Log.d("textview", "getBackground() method : " + textView.getBackground());
                // Log.d("textview", textView.getFontFeatureSettings());
            }
        });
    }
}