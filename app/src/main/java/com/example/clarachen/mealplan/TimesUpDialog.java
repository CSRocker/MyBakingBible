package com.example.clarachen.mealplan;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

import static android.app.PendingIntent.getActivity;

public class TimesUpDialog extends AppCompatActivity {

    public Ringtone ringtone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_times_up_dialog);
        //getSupportActionBar().hide();

       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        //play the alarm
        Uri alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        ringtone=RingtoneManager.getRingtone(getApplicationContext(),alert);
        ringtone.play();

    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onStop(){
        super.onStop();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    public void onClose(View view){
        //Intent intent = new Intent(TimesUpDialog.this,MainActivity.class);

        //startActivity(intent);
        ringtone.stop();
        TimesUpDialog.this.finish();


    }
}
