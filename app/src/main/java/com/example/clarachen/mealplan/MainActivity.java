package com.example.clarachen.mealplan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private int listPos;  //The position of item that user pick
    public static long bkTime =0;

    public static final String RECIPE="clara.chen.intent.recipe";
    public static final String TIMER="clara.chen.intent.timer";

    static TimesUpDialog timesUpDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Setup Spinner for Baking List
        Spinner bakingList=(Spinner) findViewById(R.id.bake_spinner);

        //List<CharSequence> spinnerArray = addSpinneritems();

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.bake_array,android.R.layout.simple_spinner_dropdown_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        bakingList.setAdapter(adapter);

        //specify the OnItemSelectedListener
        bakingList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position,long id){
                switch (position){
                    case 0:
                        listPos=position;
                        bkTime = 180000;
                        Log.d("Cupcakes ", "Recipe!");
                        Toast.makeText(parent.getContext(),"Cupcakes Recipe!", Toast.LENGTH_SHORT).show();
                        break;

                    case 1:
                        listPos=position;
                        bkTime = 120000;
                        Log.d("Cookies ", "Recipe!");
                        Toast.makeText(parent.getContext(),"Cookies Recipe!", Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        listPos=position;
                        bkTime=180000;
                        Log.d("Sponge Cake ", "Recipe!");
                        Toast.makeText(parent.getContext(),"Sponge Cake!", Toast.LENGTH_SHORT).show();
                        break;

                    case 3:
                        listPos=position;
                        bkTime=180000;
                        Log.d("Banana Bread ", "Recipe!");
                        Toast.makeText(parent.getContext(),"Banana Bread", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
                // do nothing
            }
        });

    }



   /* public List<CharSequence> addSpinneritems(){

        //Baking Items in an array
        List<CharSequence> spinnerArray = new ArrayList<CharSequence>();
        spinnerArray.add("Cupcakes");
        spinnerArray.add("Chocolate Chips Cookies");
        spinnerArray.add("Sponge Cake");
        spinnerArray.add("Banana Bread");

        return spinnerArray;
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onResume(){
        super.onResume();

    }
    public void checkRecipe(View view){

        Intent recipeSent= new Intent(MainActivity.RECIPE);
        Intent recipe= new Intent(this,Recipe.class);
        recipeSent.putExtra("Selected Item", listPos);
        recipeSent.putExtra("Baking Time",bkTime);

        Log.d("Before Main to Recipe", ".....Sending");
        sendBroadcast(recipeSent);
        Log.d("Broadcast", "Sent!");
        startActivity(recipe);
        MainActivity.this.finish();
    }

    public void startBakingTimer(View view){

        //get the baking item that user pick

        Log.d("Timer is about to ","start..");
        Intent timer= new Intent(Recipe.TIMER);
        Intent bkTimer = new Intent(this,Timer.class);

        //give the amount of time taken to bake
        //bkTime=60000;

        timer.putExtra("Selected_Item",listPos);
        timer.putExtra("Baking_Time",bkTime);

        Log.d("Before Recipe To Timer", "...Sending");
        sendBroadcast(timer);

        Log.d("Broadcast", " Sent!");
        startActivity(bkTimer);
        MainActivity.this.finish();

    }

    public void closeApp(View view){

        finish();
        System.exit(0);
    }
}
