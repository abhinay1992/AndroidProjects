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
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button playUkulele,playDrums;
    private MediaPlayer drums,ukulele;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playDrums = findViewById(R.id.playDrums);
        playUkulele = findViewById(R.id.playUkulele);

        drums = MediaPlayer.create(this,R.raw.drums);
        ukulele = MediaPlayer.create(this,R.raw.ukulele);

        playDrums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(drums.isPlaying())
                {
                    drums.pause();
                    playDrums.setText("Play Drums");
                }
                else
                {
                    if(ukulele.isPlaying())
                    {
                        ukulele.pause();
                        playUkulele.setText("Play Ukulele");
                    }
                    drums.start();
                    playDrums.setText("Pause Drums");
                }
            }
        });

        playUkulele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ukulele.isPlaying())
                {
                    ukulele.pause();
                    playUkulele.setText("Play Ukulele");
                }
                else
                {
                    if(drums.isPlaying())
                    {
                        drums.pause();
                        playDrums.setText("Play Drums");
                    }
                    ukulele.start();
                    playUkulele.setText("Pause Ukulele");
                }
            }
        });
    }
}
