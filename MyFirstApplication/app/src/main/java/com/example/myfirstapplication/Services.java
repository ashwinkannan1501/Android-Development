/** Android "Service" Component :-
 -------------------------------------
    Android Service is a component that is used to perform operations on the background such as playing music,
 handle network transactions, interacting content providers, etc. It doesn't have any UI.

    The Service runs in the background indefinitely even if teh application is destroyed.

    Moreover service can be bounded by a component to perform interactivity and inter-process communication.

    The "Service" class is the subclass of "ContextWrapper" class and the "Service" class is available
 in the "android.app" package. Another application component can start a service.

    NOTE :- Android Service component is not a thread (or) separate process.

 TYPES OF SERVICES :- There are 3 types of services. They are :-
        1) Foreground Services  2) Background Services  3) Bound Services

 TYPES OF SERVICE CLASSES :- There are 2 types of "Service" classes.
        1) Standard service class called "Service"
        2) Intent service class called "IntentService"

 There can be 2 forms of services. The Service lifecycle can follow 2 different paths :-
        1) Standard Service   2) Bounded Services

 1) Standard Services :- A service is started when component (like activity) calls "startService()"
 method, now it it runs in the background indefinitely. It is stopped by "stopService()" method.
 The service can stop itself by calling "stopSelf()" method.

 2) Bounded Service :- A service is bound when another component (eg :- client) calls "bindService()"
 method. The client can unbind the service by calling the "unbindService()" method. The service cannot
 be stopped until all the clients unbind the services.

 Understanding Started and Bound Service by background music example :-
 ----------------------------------------------------------------------------
        Suppose, i want to play music in the background, so call  the "startService()" method, But i
 want to get the information of the current song being played, I will bind the service that provides
 information about the current song.

 Service class declaration :-
 -------------------------------
    ---------------------------------------------------------------------------------------
    | public abstract class Service extends ContextWrapper implements ComponentCallbacks2 |
    ---------------------------------------------------------------------------------------

 Service class hierarchy :-
 ----------------------------
        java.lang.Object
        L> android.content.Context
           L> android.content.ContextWrapper
              L> android.app.Service

 Public Constructors :- Service()
  **/
package com.example.myfirstapplication;

// Import the necessary packages
import android.app.Notification;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;

import android.provider.Settings;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class Services extends Service {
    protected MediaPlayer mediaPlayer;

    // Public Methods :-
    @Nullable
    @Override
    public IBinder onBind(Intent intent) { // This method is used to return the communication channel to the service. May return null if clients cannot bind to the service. The returned IBinder is usually for a complex interface.
        System.out.println("'onBind()' method is activated");
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onCreate() { // This method is used to call by the system when the service is first created. It is used to create the service for the first time. Do not call this method directly.
        super.onCreate();

        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);
        mediaPlayer.setLooping(false);

        System.out.println("'onCreate()' method is activated. The service is created");

        System.out.println("getApplication() method :- " + getApplication()); // This method is used to return the application that owns this service.
        System.out.println("getForegroundServiceType() method :- " + getForegroundServiceType()); // This method is used to returns the current foreground service type if the service has become a foreground service by calling "startForeground()" method.
        // stopForeground(int flags) :- This method is used to remover the service from foreground state, allowing it to be killed if more memory is needed. This does not stops the service from running (for that you use the "stopSelf()" method), just take it out of the foreground state.
        System.out.println("getApplicationInfo() method :- " + getApplicationInfo());
        System.out.println("getApplicationContext() method :- " + getApplicationContext());
        stopForeground(true); // Same as "stopForeground(int flags)" method.

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) { // This meths used to call by the system evert time a client explicitly start the service by calling "Context.startService(Intent)", providing the arguments it supplied and a unique integer token representing the start request. Do not call this method directly.
        // For backward compatibility, the default implementation calls "onStart()" method and returns either "START_STICKY" (or) "START_STICKY_COMPATIBILITY".
        mediaPlayer.start();
        System.out.println("'onStartCommand()' method is activated. The service is started");
        // stopSelf(); // This method is used to stop the service, if it was previously started.
        // stopSelf(int startId); // Same as "stopSelf()" method.
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() { // This method is used to call by the system, to notify a service that is no longer used and it is being removed.
        mediaPlayer.stop();
        stopSelf();
        stopSelfResult(2);
        System.out.println("'onDestroy()' method is activated. The service is stopped");
        super.onDestroy();
    }

    @Override
    public Context getApplicationContext() {// This method is used to get the application context.
        System.out.println("'getApplicationContext()' method is activated");
        return super.getApplicationContext();
    }

    @Override
    public ApplicationInfo getApplicationInfo() { // This method is used to get the application info.
        System.out.println("'getApplicationInfo()' method is activated");
        return super.getApplicationInfo();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) { // This method is used to call by the system when the device configuration changes while your component is running.
        System.out.println("'onConfigurationChanged()' method is activated");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() { // This method is used to call when the overall system is running on low memory, and actively running process should trim their memory usage.
        System.out.println("'onLowMemory()' method is activated");
        super.onLowMemory();
    }

    @Override
    public boolean onUnbind(Intent intent) { // This method is used to call when all the clients have disconnected from a particular interface published by the service. The default implementation does nothing and returns false.
        System.out.println("'onUnbind()' method is activated");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) { // This method is used to call when new clients have connected to the service, after it had previously been notified that all the disconnected in it's 'onUnbind()' method. This will only be  called if the implementation of 'onUnbind()' method was overridden to return true
        System.out.println("'onRebind()' method is activated");
        super.onRebind(intent);
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) { // This method is used to call if the service is currently running and the user has removed a task comes from the service's application.
        System.out.println("'onTaskRemoved()' method is activated");
        super.onTaskRemoved(rootIntent);
    }

    @Override
    public void onTrimMemory(int level) { // This method is used to call when the OS has determined that it is a good time for a process to trim unneeded memory from it's process.
        System.out.println("'onTrimMemory()' method is activated");
        super.onTrimMemory(level);
    }

    @Override
    public ComponentName startForegroundService(Intent service) { // This method is used to start the foreground service.
        System.out.println("'startForegroundService()' method is activated");
        return super.startForegroundService(service);
    }

    @Override
    public ComponentName startService(Intent service) { // This method is used to start the service.
        System.out.println("'startService()' method is activated");
        return super.startService(service);
    }

    @Override
    public boolean stopService(Intent name) { // This method is used to stop the service.
        System.out.println("'stopService()' method is activated");
        return super.stopService(name);
    }
}
