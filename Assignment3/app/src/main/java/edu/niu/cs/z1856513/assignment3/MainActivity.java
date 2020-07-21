/****************************************************************************
 *                                                                          *
 *                  Name :- Abhinay Imandi                                  *
 *                                                                          *
 *                  ZID :- Z1856513                                         *
 *                                                                          *
 *                  Due Date :- ?                                           *
 *                  Assignment :- 3                                         *
 *                  Description :- An application with spinners, textview   *
 *                                 imageview, to display recipes for food   *
 ****************************************************************************/

package edu.niu.cs.z1856513.assignment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner recipes;
    private Button recipeBtn;
    private ImageView recipeImg;
    private int[] imgs = {R.drawable.dumbiryani,R.drawable.chickenfry,R.drawable.mysorebonda,R.drawable.panipuri,R.drawable.payasam};
    private String recipeName=null;
    private int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recipes = findViewById(R.id.recipeSpinner);
        recipeBtn = findViewById(R.id.recipeBtn);
        recipeImg = findViewById(R.id.recipeImage);

        ArrayAdapter<CharSequence> recipeAdapt = ArrayAdapter.createFromResource(getApplicationContext(),R.array.RecipeNames,R.layout.spinnerview);
        recipes.setAdapter(recipeAdapt);
        recipes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                recipeImg.setImageResource(imgs[position]);
                recipeName = parent.getItemAtPosition(position).toString();
                pos = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        recipeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent descIntent = new Intent(MainActivity.this,DescriptionActivity.class);
                descIntent.putExtra("recipe",recipeName);
                descIntent.putExtra("position",pos);
                startActivity(descIntent);
            }
        });
    }
}
