/****************************************************************************
 *                                                                          *
 *                  Name :- Abhinay Imandi                                  *
 *                  ZID :- Z1856513                                         *
 *                  Due Date :- ?                                           *
 *                  Portfolio :- 14                                          *
 *                  Description :- An application which uses munus and database *
 ****************************************************************************/

package edu.niu.cs.z1856513.databaseandmenus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.Toast;

import java.util.ArrayList;

public class DeleteActivity extends AppCompatActivity
{
    private DatabaseManager databaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        databaseManager = new DatabaseManager(this);
        updateView();
    }

    public void updateView()
    {
        ArrayList<Candy> candies = databaseManager.selectAll();

        //Create the Layout
        RelativeLayout layout = new RelativeLayout(this);
        ScrollView scrollView = new ScrollView(this);
        RadioGroup radioGroup = new RadioGroup(this);

        //Loop to process each candy in the arraylist
        for(Candy candy: candies)
        {
            //Create a radiobutton and add it to the radioGroup.
            RadioButton radioButton = new RadioButton(this);

            //Put the info into RadioButton
            radioButton.setId(candy.getId());
            radioButton.setText(candy.candyToString());

            //add the radioButton to the radioGroup
            radioGroup.addView(radioButton);
        }


        //Set the handler for the radiobuttons in the radioGroup
        RadioButtoHandler handler = new RadioButtoHandler();
        radioGroup.setOnCheckedChangeListener(handler);

        //Create a back button
        Button backBtn = new Button(this);
        backBtn.setText("Back");
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        // add RadioGroup to the scrollview
        scrollView.addView(radioGroup);
        //Add the scrollview to the relative Layout
        layout.addView(scrollView);

        //Set up some parameters to make the back button display at the bottom of the screen
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.setMargins(0,0,0,60);

        //add back button to the relative layout using the parameters
        layout.addView(backBtn,params);

        //display the
        setContentView(layout);





    }//end updateView
    private  class RadioButtoHandler implements RadioGroup.OnCheckedChangeListener
    {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId)
        {
            databaseManager.deleteByID(checkedId);
            Toast.makeText(DeleteActivity.this,"candy deleted",Toast.LENGTH_SHORT).show();

            updateView();
        }
    }//end RadioButton
}