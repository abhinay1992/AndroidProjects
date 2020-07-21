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
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private Button drums,tabla,piano,guitar,violin,trumpet;
    private MediaPlayer drumsMP,tablaMP,pianoMP,guitarMP,violinMP,trumpetMP;
    private List<MediaPlayer> MPList = new ArrayList<>();
    private int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drums = findViewById(R.id.drums);
        tabla = findViewById(R.id.tabla);
        piano = findViewById(R.id.piano);
        guitar = findViewById(R.id.guitar);
        violin = findViewById(R.id.violin);
        trumpet = findViewById(R.id.trumpet);

        drumsMP = MediaPlayer.create(this,R.raw.drum_solo);
        tablaMP = MediaPlayer.create(this,R.raw.tabla);
        pianoMP = MediaPlayer.create(this,R.raw.piano_melody);
        guitarMP = MediaPlayer.create(this,R.raw.guitar_mexican);
        violinMP = MediaPlayer.create(this,R.raw.pirates_of_caribbean);
        trumpetMP = MediaPlayer.create(this,R.raw.trumpet_alarm);

        MPList.add(drumsMP);
        MPList.add(tablaMP);
        MPList.add(pianoMP);
        MPList.add(guitarMP);
        MPList.add(violinMP);
        MPList.add(trumpetMP);

        drums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(drumsMP.isPlaying())
                {
                    drumsMP.pause();
                }
                else
                {
                    if(MPList.get(index).isPlaying())
                    {
                        MPList.get(index).pause();
                    }
                    drumsMP.start();
                    index = MPList.indexOf(drumsMP);
                }
            }
        });

        tabla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(tablaMP.isPlaying())
                {
                    tablaMP.pause();
                }
                else
                {
                    if(MPList.get(index).isPlaying())
                    {
                        MPList.get(index).pause();
                    }
                    tablaMP.start();
                    index = MPList.indexOf(tablaMP);
                }
            }
        });

        piano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pianoMP.isPlaying())
                {
                    pianoMP.pause();
                }
                else
                {
                    if(MPList.get(index).isPlaying())
                    {
                        MPList.get(index).pause();
                    }
                    pianoMP.start();
                    index = MPList.indexOf(pianoMP);
                }
            }
        });

        guitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(guitarMP.isPlaying())
                {
                    guitarMP.pause();
                }
                else
                {
                    if(MPList.get(index).isPlaying())
                    {
                        MPList.get(index).pause();
                    }
                    guitarMP.start();
                    index = MPList.indexOf(guitarMP);
                }
            }
        });

        violin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(violinMP.isPlaying())
                {
                    violinMP.pause();
                }
                else
                {
                    if(MPList.get(index).isPlaying())
                    {
                        MPList.get(index).pause();
                    }
                    violinMP.start();
                    index = MPList.indexOf(violinMP);
                }
            }
        });

        trumpet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(trumpetMP.isPlaying())
                {
                    trumpetMP.pause();
                }
                else
                {
                    if(MPList.get(index).isPlaying())
                    {
                        MPList.get(index).pause();
                    }
                    trumpetMP.start();
                    index = MPList.indexOf(trumpetMP);
                }
            }
        });


    }
}
