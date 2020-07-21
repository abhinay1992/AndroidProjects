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
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class DescriptionActivity extends AppCompatActivity {

    private Button backBtn;
    private TextView descView,recipeView;
    private int pos = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        Intent recipeIntent = getIntent();
        String[] descs = getResources().getStringArray(R.array.RecipeDesc);

        pos = recipeIntent.getIntExtra("position",0);
        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        descView = findViewById(R.id.recipeTxt);
        recipeView = findViewById(R.id.recipeName);

        recipeView.setText(recipeIntent.getStringExtra("recipe"));
        descView.setText(descs[pos]);
    }
}
