package com.nonexistentware.igor.demoghostcity;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class ScreenOfChoice extends AppCompatActivity {

    //timer
    private CountDownTimer myCountDownTimer;

    private Typeface typeface;

    private Timer timer = new Timer();
    private Handler handler = new Handler();

    //screen size
    private int screenWidth;
    private int screenHeight;

    private ImageView person, personSecond, personThird;
    private TextView bodyAvailable, gameLogo, invisibleTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //imageView
        person = (ImageView) findViewById(R.id.person);
        personSecond = (ImageView) findViewById(R.id.personSecond);
        personThird = (ImageView) findViewById(R.id.personThird);

        //textView
        bodyAvailable = (TextView) findViewById(R.id.bodyAvailable);
        gameLogo = (TextView) findViewById(R.id.gameLogo);
        invisibleTimer = (TextView) findViewById(R.id.invisibleTimer);

        //custom font
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/PIXAR.ttf");
        bodyAvailable.setTypeface(typeface);
        gameLogo.setTypeface(typeface);


        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent crimeStory = new Intent(ScreenOfChoice.this, PersonRobber.class); //first person is personRobber
                startActivity(crimeStory);
            }
        });
        
        personSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent policeStory = new Intent(ScreenOfChoice.this, PersonPoliceman.class); //second person is policeman
                startActivity(policeStory);
            }
        });

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 0, 20);

        myCountDownTimer = new CountDownTimer(5*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                invisibleTimer.setText("" + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
            gameLogo.setText("pick the person");
            }
        }.start();
    }

}
