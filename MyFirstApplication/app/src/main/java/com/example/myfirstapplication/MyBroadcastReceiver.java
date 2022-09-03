package com.example.myfirstapplication;

// Import the necessary packages
import android.content.Context;
import android.content.Intent;

import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) { // This method will invoke when the broadcast message is received in the app

        switch (intent.getAction()) {
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);

                if (isAirplaneModeOn) {
                    Toast.makeText(context, "Airplane mode is on", Toast.LENGTH_SHORT).show();
                    System.out.println("Airplane Mode is on");
                } else {
                    Toast.makeText(context, "Airplane mode is off", Toast.LENGTH_SHORT).show();
                    System.out.println("Airplane mode is off");
                }
                break;

            case Intent.ACTION_POWER_CONNECTED:
                Toast.makeText(context, "Charger is connected and power is supplied", Toast.LENGTH_SHORT).show();
                System.out.println("Charger is connected and power is supplied");
                break;

            case Intent.ACTION_POWER_DISCONNECTED:
                Toast.makeText(context, "Charger is disconnected and power is not supplied", Toast.LENGTH_SHORT).show();
                System.out.println("Charger is disconnected and power is not supplied");
                break;

            case Intent.ACTION_SCREEN_ON:
                Toast.makeText(context, "Mobile Screen is on", Toast.LENGTH_SHORT).show();
                System.out.println("Mobile Screen is on");
                break;

            case Intent.ACTION_SCREEN_OFF:
                Toast.makeText(context, "Mobile Screen is off", Toast.LENGTH_SHORT).show();
                System.out.println("Mobile Screen is off");
                break;

            default:
                Toast.makeText(context, "Wrong action..... Doesn't receive a broadcast message", Toast.LENGTH_SHORT).show();
                break;
        }

        // Public Methods :-

        // abortBroadcast() method :- This method is used to sets the flag indicating that this receiver should abort the current broadcast. It only works with broadcast sent through "Context.sendOrderedBroadcast"
        abortBroadcast();

        // clearAbortBroadcast() method :- This method is used to clears the flag indicating that this receiver should abort the current broadcast.
        clearAbortBroadcast();

        // isInitialStickyBroadcast() method :- This method is used to returns true if the receiver
        // is currently processing the initial value of a sticky broadcast - that is the value that
        // was last broadcast and is currently held in the sticky cache, so this is not directly the
        // result of a broadcast right now.
        boolean isInitialStickyBroadcastMethod = isInitialStickyBroadcast();
        System.out.println("isInitialStickyBroadcast() method :- " + isInitialStickyBroadcastMethod);

        // isOrderedBroadcast() method :- This method is used to returns true if the receiver is currently processing an ordered broadcast.
        boolean isOrderedBroadcastMethod = isOrderedBroadcast();
        System.out.println("isOrderedBroadcast() method :- " + isOrderedBroadcastMethod);

        //onReceive(context, intent); // This method is will be called when the broadcast receiver is receiving an intent broadcast.

        // peekService() method :- This method is used to provide a binder to an already bound service.
        IBinder peekServiceMethod = peekService(context, intent);
        System.out.println("peekService() method :- " + peekServiceMethod);

        setDebugUnregister(true); // This method is used to control the inclusion of debugging help for mismatched calls to "Context.registerReceiver"
        setOrderedHint(true); // This method is used to set the hint about whether this broadcast receiver is running in ordered mode.
        //setResult(int code, String data, Bundle extras); // This method is used to change all of the result data returned from this broadcast. It only works with broadcast sent through "Context.sendOrderedBroadcast".
        setResultCode(0); // This method is used to change the current result code of this broadcast. It only works with broadcast sent through "Context.sendOrderedBroadcast".
        setResultData("setResultData() method"); // This method is used to change the current result data of this broadcast. It only works with broadcast sent through "Context.sendOrderedBroadcast".
        // setResultExtras(Bundle extras); // This method is used to change the current result extras of this broadcast. It only works with broadcast sent through "Context.sendOrderedBroadcast".

        // goAsync() method :- This method will be called by an application in "onReceive(Context, Intent)" to allow it to keep the broadcast active after returning from that function.
        BroadcastReceiver.PendingResult goAsyncMethod = goAsync();
        System.out.println("goAsync() method :- " + goAsyncMethod);

        // getAbortBroadcast() method :- This method is used to return the flag indicating whether or not this receiver should abort the current broadcast.
        boolean getAbortBroadcastMethod = getAbortBroadcast();
        System.out.println("getAbortBroadcast() method :- " + getAbortBroadcastMethod);

        // getDebugUnregister() method :- This method is used to return the last value given to "setDebugUnregister(boolean)" method.
        boolean getDebugUnregisterMethod = getDebugUnregister();
        System.out.println("getDebugUnregister() method :- " + getDebugUnregisterMethod);

        // getResultCode() method :- This method is used to retrieve the current result code, as set by the previous receiver.
        int getResultCodeMethod = getResultCode();
        System.out.println("getResultCode() method :- " + getResultCodeMethod);

        // getResultData() method :- This method is used to retrieve the current result data, as set by the previous receiver.
        String getResultDataMethod = getResultData();
        System.out.println("getResultData() method " + getResultDataMethod);

        // getResultExtras() method :- This method is used to retrieve the current result extras, as set by the previous receiver. Any changes you make to the returned Map will be propagated to the next receiver.
        Bundle getResultExtrasMethod = getResultExtras(true);
        System.out.println("getResultExtras() method :- " + getResultExtrasMethod);
    }
}
