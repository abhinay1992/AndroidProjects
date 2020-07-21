/****************************************************************************
 *                                                                          *
 *                  Name :- Abhinay Imandi                                  *
 *                                                                          *
 *                  ZID :- Z1856513                                         *
 *                                                                          *
 *                  Due Date :- ?                                           *
 *                  Assignment :- 4                                         *
 *                  Description :- An application to display the splash     *
 *                                  screen and to perform playing of sounds *
 ****************************************************************************/

package edu.niu.cs.z1856513.assignment4;

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

                startActivity(new Intent(SplashScreen.this,MainActivity.class));
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task,5000);
    }
}
