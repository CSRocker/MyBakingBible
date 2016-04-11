package com.example.clarachen.mealplan;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Timer extends AppCompatActivity {

    public static final String TIMER="clara.chen.intent.timer";

    public static int selectedPos=0;
    public static long bakingTime=0;

    public CountDownTimer countDownTimer;

    private static final String timerFormat="%02d:%02d:%02d";

    int seconds, minutes;

    TextView timerTxt,timerDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        timerTxt=(TextView)findViewById(R.id.timer);
        timerDone=(TextView)findViewById(R.id.done);



        //get Count down timer
        countDownTimer =new CountDownTimer(bakingTime,1000){

            //get timer into hh:mm:ss format every seconds changes
            public void onTick(long millisUntilFinished){
                timerTxt.setText(""+String.format(timerFormat,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish(){
                timerTxt.setText("00:00:00");
                timerDone.setText("Times Up!!");
                Intent alarm = new Intent(Timer.this,TimesUpDialog.class);
                startActivity(alarm);
            }
        }.start();

    }

    /*public void schedulealarm(){

        Intent alarm = new Intent(this,Alarm.class);
        //set the alarm time at bakingTimes(eg.10minutes) after current time
        Long timesUp= new GregorianCalendar().getTimeInMillis()+bakingTime;

        //create the AlarmManager
        AlarmManager alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);

        //set the alarm for particular time (i.e bkTime period after current time)
        alarmManager.set(AlarmManager.RTC_WAKEUP, timesUp, PendingIntent.getBroadcast(this, 1,
                alarm, PendingIntent.FLAG_UPDATE_CURRENT));

    }
*/

    public void closeTimer(View view){

        //stop the timer
        if(countDownTimer!=null){
            countDownTimer.cancel();
            countDownTimer=null;
        }
        Intent main = new Intent(Timer.this,MainActivity.class);
        startActivity(main);
        Timer.this.finish();
    }

}
