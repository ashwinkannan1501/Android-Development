/** BroadcastReceiver in Android :-
 ------------------------------------
        The Broadcast in Android is the system-wide events that can occur when the device starts,
 when the message is received on the device (or) when incoming calls are received, (or) when device
 goes to airplane mode, etc. Broadcast Receivers are used to respond to these system-wide events.
 Broadcast Receivers allows us to register for the system and application events, and when that event
 happens, then the register receivers got notified.

        There are mainly 2 types of Broadcast Receivers :- (i) Static Broadcast Receivers (ii) Dynamic Broadcast Receivers

 (i) Static Broadcast Receivers :-
 ------------------------------------
    These types of receivers are declared in the manifest file and works even if the app is closed.

 (ii) Dynamic Broadcast Receivers :-
 --------------------------------------
    These types of receivers, work only if the app is active (or) minimized. Since from API level 26,
 most of the broadcast can only be caught by the dynamic receiver. There are some static fields defined
 in the Intent class which can be used to broadcast different events.

    The two main things that we have to do in order to use the broadcast receiver in our application are :-
    (i) Creating the Broadcast Receiver
    (ii) Registering a Broadcast Receiver

 What is a Broadcast ? :-
 -------------------------
        A messaging system across apps and outside of the normal user flow. Apps can send (or) receive
 messages from the Android system and other Android Apps. It is similar to the publish-subscribe pattern.
 Broadcast are sent when an event of interest occurs.

        Apps can also send custom broadcast, for example, to notify other apps of something that they
 might be interested in (for example, some new data has been downloaded).

 System Broadcast :-
 ---------------------
        The system automatically sends broadcast when various system events occurs.
 Example :- When the system switches in and out of airplane mode. System broadcast are sent to all
 apps that are subscribed to receive the events.

 Handling System Broadcast Messages :-
 ----------------------------------------
        The broadcast message itself is wrapped in an Intent. Action String identifies the events that
 occurred (Example:android.intent.action.AIRPLANE_MODE).

        The intent may also include additional information bundled into it's extra field. For example,
 the airplane mode intent includes a boolean extra that indicates whether or not Airplane Mode is on.

 BroadcastReceiver class declaration :-
 -----------------------------------------
    ----------------------------------------------------------
    | public abstract class BroadcastReceiver extends Object |
    ----------------------------------------------------------

 BroadcastReceiver class hierarchy :-
 ---------------------------------------
    ----------------------------------------
    | java.lang.Object                     |
    | L> android.content.BroadcastReceiver |
    ----------------------------------------

 Nested Class :-
 ----------------
 1) class BroadcastReceiver.PendingResult :- State for a result that is pending for a broadcast receiver.

 Public Constructors :- 1) BroadcastReceiver() :-
 **/
package com.example.myfirstapplication;

// Import the necessary packages
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.IntentFilter;
import android.content.Intent;

public class Program_21_BroadcastReceiver_Class extends AppCompatActivity {

    MyBroadcastReceiver myBroadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_21_broadcast_receiver_class);

        myBroadcastReceiver = new MyBroadcastReceiver();

//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
//        registerReceiver(myBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onStart() {
      IntentFilter intentFilter = new IntentFilter();
      intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
      intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
      intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
      intentFilter.addAction(Intent.ACTION_SCREEN_ON);
      intentFilter.addAction(Intent.ACTION_SCREEN_OFF);

      registerReceiver(myBroadcastReceiver, intentFilter);

        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(myBroadcastReceiver);
        super.onStop();
    }
}