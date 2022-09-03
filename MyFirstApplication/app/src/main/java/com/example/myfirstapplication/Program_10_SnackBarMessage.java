/** SnackBar Messages :-
 -----------------------------
        The Android "SnackBar" is a lightweight widget and they are used to show messages in the bottom of the application with swiping enabled.

        SnackBar provides lightweight feedback about an operation.They sho a brief message at the
 bottom of the screen on mobile and lower left on larger devices. Snackbar appear above all the other
 elements on screen and only one snckbar message can be displayed at a time.

        They automatically disappear after a timeout (or) after user interaction elsewhere on the screen,
 particularly after interactions that summon a new surface (or) activity. Snackbars can be swiped off screen.

 Snackbar class declaration :-
 --------------------------------
        ------------------------------------------------------------------
        | public class Snackbar extends BaseTransientBottomBar<Snackbar> |
        ------------------------------------------------------------------
 Snackbar class hierarchy :-
 -----------------------------
     java.lang.Object
     ↳ com.google.android.material.snackbar.BaseTransientBottomBar<com.google.android.material.snackbar.Snackbar>
        ↳ com.google.android.material.snackbar.Snackbar

 Nested Classes :-
 ---------------------
 (i)class Snackbar.Callback :- Callback class for snackbar instances.

 Constants :-
 --------------
 (i) int ANIMATION_MODE_FADE :- Animation mode that corresponds to the fade in and out animations
 (ii) int ANIMATION_MODE_SLIDE :- Animation mode that corresponds to the slide in and out animations.
 (iii) int LENGTH_INDEFINITE :- Show the snackbar indefinitely.
 (iv) int LENGTH_LONG :- Show the snackbar for a long period of time.
 (v) int LENGTH_SHORT :- Show the snackbar for the short period of time.
  **/
package com.example.myfirstapplication;

// Import the necessary packages
import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import android.view.View;
import android.view.View.OnClickListener;

import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import android.graphics.Color;

public class Program_10_SnackBarMessage extends AppCompatActivity {
    Button simpleSnackBarButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_10_snackbar_message);

        simpleSnackBarButton = findViewById(R.id.simple_snackbar_button);

        new SnackBarMessage(simpleSnackBarButton);
    }
}

class SnackBarMessage implements OnClickListener {

    SnackBarMessage(Button button) {
        button.setHapticFeedbackEnabled(true);
        button.setOnClickListener(this::onClick);
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.simple_snackbar_button) {
            Snackbar snackbar;
            // Methods :-
            snackbar = Snackbar.make(view, "This is a snackbar message which is deleted", Snackbar.LENGTH_INDEFINITE); // The "make()" method is used to make/create a snackbar to display a message.
            snackbar.setAction("Undo", new OnClickListener() { // The "setAction()" method is used to set the action to be displayed in the "BaseTransientBottomBar" (Snackbar).
                @Override
                public void onClick(View view) {
                    Snackbar deletedSnackBar = Snackbar.make(view, "The message is restored", Snackbar.LENGTH_SHORT);
                    deletedSnackBar.setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE); // The "setAnimationMode()" method is used to set the animation mode.
                    deletedSnackBar.setBackgroundTint(Color.BLACK); // The "setBackgroundTint()" method is used to set the tint color of the background drawable.
                    deletedSnackBar.setTextColor(Color.WHITE); // The "setTextColor()" method is used to set the text color of the message specified in the "setText(CharSequence)" and "setText(int)"
                    deletedSnackBar.setDuration(BaseTransientBottomBar.LENGTH_SHORT); // The "setDuration()" method is used to set the duration of the snackbar. (i.e) how long to show the view for.
                    deletedSnackBar.show(); // The "show()" method is used to show the snackbar.
                }
            });
            snackbar.setActionTextColor(Color.RED); // The "setActionTextColor()" method is used to set the text color of the action specified in the snackbar "setAction(CharSequence text, View.OnClickListener listener)".
            snackbar.setText("This is a snackbar message which is deleted"); // The "setText()" method is used to set the text in the snackbar.
            snackbar.setTextColor(Color.MAGENTA); // The "setTextColor()" method is used to set the text color of the message specified in the "setText(CharSequence)" and "setText(int)"
            snackbar.setBackgroundTint(Color.YELLOW); // The "setBackgroundTint()" method is used to set the tint color of the background drawable.
            snackbar.setMaxInlineActionWidth(Dimension.DP); // The "setMaxInLineActionWidth()" method is used to set the maximum width of the action to be in the same line as the message. If the width is exceeded, the action would go to next line.
            snackbar.setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE); // The "setAnimationMode()" method is used to set the animation mode.
            snackbar.show(); // The "show()" method is used to show the snackbar.

            System.out.println("getDuration() method :- " + snackbar.getDuration()); // The "getDuration()" method is used to return the duration.
            System.out.println("isShown() method :- " + snackbar.isShown()); // The "isShown()" method is used to return true/false whether the snackbar is currently being shown.

            //snackbar.dismiss(); // The "dismiss()" method is used to dismiss the snackbar.

            // Inherited Methods :-
            //------------------------
            //snackbar.setAnchorView(View.VISIBLE); // This method is used to set the view of the snackbar should be anchored above by id (or) view.
            snackbar.setAnchorViewLayoutListenerEnabled(true); // This method is used to set the boolean value whether the anchor view layout listener is enabled.
            //snackbar.setBehavior(SwipeDismissBehavior.OnDismissListener); // This method is used to set the behavior to be used in this snackbar.
            //snackbar.setDuration(Snackbar.LENGTH_LONG); // The "setDuration()" method is used to set the duration of the snackbar. (i.e) how long to show the view for.
            snackbar.setGestureInsetBottomIgnored(true); // This method is used to set whether this bottom bar should adjust it's position based on the system gesture area on android Q and above.

            System.out.println("getAnchorView() method :- " + snackbar.getAnchorView()); // This method is used to returns the anchor view for the snackbar.
            System.out.println("getAnimationMode() method :- " + snackbar.getAnimationMode()); // This method is used to return the animation mode.
            System.out.println("getBehavior() method :- " + snackbar.getBehavior()); // This method is used to return the behavior of the snackbar.
            System.out.println("getContext() method :- " + snackbar.getContext()); // This method is used to return the context of the snackbar.
            System.out.println("getView() method :- " + snackbar.getView()); // This method is used to return the view of the snackbar.
            //System.out.println("" + snackbar.has);
            System.out.println("isAnchorViewLayoutListenerEnabled() method :- " + snackbar.isAnchorViewLayoutListenerEnabled()); // This method is used to return a boolean value based on the anchor view layout listener is enabled.
            System.out.println("isGestureInsetBottomIgnored() method :- " + snackbar.isGestureInsetBottomIgnored()); // This method is used to return boolean value whether this bottom bar should it's position based on the system gesture area on Android Q and above.
            System.out.println("isShown() method :- " + snackbar.isShown()); // The "isShown()" method is used to return true/false whether the snackbar is currently being shown.
            System.out.println("isShownOrQueued() method :- " + snackbar.isShownOrQueued()); // This method is used to returns teh boolean value whether this snackbar is currently being shown, or is queued to be shown next.

            // snackbar.addCallback() // This method is used to adds teh specified callback to the list of callbacks that will be notified of transient bottom bar events.
            // snackbar.removeCallback() // This method is used to removes the specified callback from the list of callbacks that will be notified of transient bottom bar events.
        }
    }
}