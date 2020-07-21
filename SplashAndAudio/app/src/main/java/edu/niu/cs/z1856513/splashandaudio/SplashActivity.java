/****************************************************************************
 *                                                                          *
 *                  Name :- Abhinay Imandi                                  *
 *                  ZID :- Z1856513                                         *
 *                  Due Date :- ?                                           *
 *                  Portfolio :- 10                                          *
 *                  Description :- An application to display                *
 *                                  the splash screen and play audio        *
 ****************************************************************************/

package edu.niu.cs.z1856513.splashandaudio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                //Finish Activity
                finish();

                //Go to Activity

                startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }
        };

        Timer timer = new Timer();

        timer.schedule(task,4000);
    }
}
