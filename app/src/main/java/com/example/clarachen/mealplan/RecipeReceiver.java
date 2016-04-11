package com.example.clarachen.mealplan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by ClaraChen on 3/31/16.
 */
public class RecipeReceiver extends BroadcastReceiver {

    public RecipeReceiver(){
        //Constructor
    }

    @Override
    public void onReceive(Context context, Intent intent){
        //Request Broadcast
        Log.d("Debug --->","Recipe Request - on Recieve");

        String action = intent.getAction();
        Log.d("Debug --->","Broadcast received: "+action);
        Log.d("Debug --->","Action: "+intent.getAction());

        if(intent.getAction().equals(Recipe.RECIPE)){
            int local_selectedPos=intent.getExtras().getInt("Selected Item");

            Recipe.selectedPos=local_selectedPos;
        }
    }
}
