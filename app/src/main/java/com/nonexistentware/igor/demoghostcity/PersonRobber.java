package com.nonexistentware.igor.demoghostcity;

import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class PersonRobber extends AppCompatActivity {

    private TextView storyName, bulletInt, nextAction, dialogueConsole;

    private Typeface typeface;

    private Handler handler = new Handler();
    private Timer timer = new Timer();
    private CountDownTimer myCountDownTimer;


    private int state = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_robber);


        storyName = (TextView) findViewById(R.id.storyName);
        bulletInt = (TextView) findViewById(R.id.bulletInt);
        nextAction = (TextView) findViewById(R.id.nextBtn);
        dialogueConsole = (TextView) findViewById(R.id.dialogueConsole);

        //bullets int
        bulletInt.setVisibility(View.INVISIBLE);


        nextAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state == 0) {
                    storyName.setVisibility(View.INVISIBLE);
                    dialogueConsole.setText("Вы только что ограбили банк");
                }

                if (state ==1) {
                    bulletInt.setVisibility(View.VISIBLE);
                    dialogueConsole.setText("");
                }

            }
        });

//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//
//            }
//        }, 0, 20);
//
//        myCountDownTimer = new CountDownTimer(5*1000, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//
//            }
//
//            @Override
//            public void onFinish() {
//
//            }
//        }.start();
    }
}
