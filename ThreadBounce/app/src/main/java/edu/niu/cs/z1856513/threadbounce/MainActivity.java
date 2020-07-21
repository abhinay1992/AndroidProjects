/****************************************************************************
 *                                                                          *
 *                  Name :- Abhinay Imandi                                  *
 *                  ZID :- Z1856513                                         *
 *                  Due Date :- ?                                           *
 *                  Portfolio :- 13                                         *
 *                  Description :- An application to use threads and display*
 *                                  bouncing ball                           *
 ****************************************************************************/

package edu.niu.cs.z1856513.threadbounce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout layout = findViewById(R.id.frameLayout);
        BounceSurfaceView bounceSurfaceView = new BounceSurfaceView(this,null);
        layout.addView(bounceSurfaceView);
    }
}
