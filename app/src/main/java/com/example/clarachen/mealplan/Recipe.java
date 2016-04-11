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
    public static long bkTime =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Setup the Recipe TextView
        TextView recipe_TxtView=(TextView)findViewById(R.id.recipe);
        String ingredients;
        switch (selectedPos){
            case 0:
                ingredients =this.getString(R.string.cupcake_recipe);
                recipe_TxtView.setText(""+ingredients);
                break;
            case 1:
                ingredients =this.getString(R.string.cookies_recipe);
                recipe_TxtView.setText(""+ingredients);
                break;
            case 2:
                ingredients =this.getString(R.string.spongecake_recipe);
                recipe_TxtView.setText(""+ingredients);
                break;
            case 3:
                ingredients =this.getString(R.string.bananabread_recipe);
                recipe_TxtView.setText(""+ingredients);
                break;
            default:
                recipe_TxtView.setText("Invalid Choice");
                break;

        }

        Log.d("Debug -->"," Here is the Recipe");

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
