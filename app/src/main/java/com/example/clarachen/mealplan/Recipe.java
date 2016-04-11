package com.example.clarachen.mealplan;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.GregorianCalendar;

public class Recipe extends AppCompatActivity {

    public static final String RECIPE="clara.chen.intent.recipe";
    public static final String TIMER="clara.chen.intent.timer";

    public static int selectedPos =0;
    public static long bkTime =60000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(selectedPos==selectedPos){
           //Show recipe

            Log.d("Debug -->"," Here is the Recipe");
        }

    }

    public void startBakingTimer(View view){


        Log.d("Timer is about to ","start..");
        Intent timer= new Intent(Recipe.TIMER);
        Intent bkTimer = new Intent(this,Timer.class);

        //give the amount of time taken to bake
        bkTime=60000;

        timer.putExtra("Selected_Item",selectedPos);
        timer.putExtra("Baking_Time",bkTime);

        Log.d("Before Recipe To Timer", "...Sending");
        sendBroadcast(timer);


        startActivity(bkTimer);
        Recipe.this.finish();
    }

    public void backToMain(View view){
        Intent main = new Intent(this,MainActivity.class);
        startActivity(main);
        Recipe.this.finish();
    }

}
