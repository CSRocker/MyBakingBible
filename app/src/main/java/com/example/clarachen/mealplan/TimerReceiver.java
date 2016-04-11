package com.example.clarachen.mealplan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by ClaraChen on 3/31/16.
 */
public class TimerReceiver extends BroadcastReceiver {
    public TimerReceiver(){
        //constructor
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        //Request Broadcast
        Log.d("Debug ---->", "Timer - Started");

        String action = intent.getAction();
        Log.d("Debug ---->", "Broadcast recieved: "+action);

        if(intent.getAction().equals(Timer.TIMER)){
            int local_SelectedPos=intent.getExtras().getInt("Selected_Item");
            long local_bakingTime=intent.getExtras().getLong("Baking_Time");


            Log.d("Baking time is ",Long.toString(local_bakingTime));
            Timer.selectedPos=local_SelectedPos;
            Timer.bakingTime=local_bakingTime;
            Log.d("Baking time is ",Long.toString(Timer.bakingTime));
        }



    }
}
