/****************************************************************************
 *                                                                          *
 *                  Name :- Abhinay Imandi                                  *
 *                  ZID :- Z1856513                                         *
 *                  Due Date :- ?                                           *
 *                  Portfolio :- 7                                          *
 *                  Description :- An application to display                *
 *                                  the dynamic layout with images          *
 ****************************************************************************/

package edu.niu.cs.z1856513.imagesanddynamiclayout;

import android.app.Activity;
import android.support.v4.content.res.ResourcesCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

    private LinearLayout gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gallery = findViewById(R.id.charLayout);

        fillGallery();
    }//end OnCreate

    private void fillGallery()
    {
        ImageButton characterIB;

        for(int cnt=0;cnt<CharacterInfo.description.length;cnt++)
        {
            //Create ImageButton
            characterIB = new ImageButton(this);

            //Create a Character Object
            Character charac = new Character(CharacterInfo.description[cnt],CharacterInfo.id[cnt]);

            //Put the information for the character on the ImageButton
            characterIB.setContentDescription(charac.getCharDescription());
            characterIB.setImageDrawable(ResourcesCompat.getDrawable(getResources(),charac.getCharID(),null));

            //Handle button click
            characterIB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),v.getContentDescription().toString(),Toast.LENGTH_SHORT).show();
                }
            });

            //Add the imageButton to LinearLayout
            gallery.addView(characterIB);
        }//End for loop
    }//end fillGallery
}
