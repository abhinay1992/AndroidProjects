package edu.niu.cs.z1856513.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                //Finish Activity
                finish();

                //Go to Activity

                startActivity(new Intent(SplashScreen.this,MainActivity.class));
            }
        };

        Timer timer = new Timer();

        timer.schedule(task,5000);
    }
}