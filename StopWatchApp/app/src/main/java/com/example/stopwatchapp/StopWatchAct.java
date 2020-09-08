package com.example.stopwatchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchAct extends AppCompatActivity {
    Button btnstart , btnstop;
    ImageView icanchor;
    Animation roundingalong;
    Chronometer timerHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnstart = findViewById(R.id.btnstart);
        icanchor = findViewById(R.id.icanchor);
        btnstop = findViewById(R.id.btnstop);
        timerHere = findViewById(R.id.timerHere);

        //create optional animation
        btnstop.setAlpha(0);

        //load animation
        roundingalong = AnimationUtils.loadAnimation(this,R.anim.roundingalong);

        //import font
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"font/MMedium.ttf");

        //customize font
        btnstart.setTypeface(MMedium);
        btnstop.setTypeface(MMedium);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //passing animation
                icanchor.startAnimation(roundingalong);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();
                // start time
                timerHere.setBase(SystemClock.elapsedRealtime());
                timerHere.start();

            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerHere.setBase(SystemClock.elapsedRealtime());
                timerHere.stop();
                icanchor.clearAnimation();
            }
        });
    }
}