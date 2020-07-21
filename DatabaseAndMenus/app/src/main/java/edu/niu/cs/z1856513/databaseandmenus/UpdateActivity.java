/****************************************************************************
 *                                                                          *
 *                  Name :- Abhinay Imandi                                  *
 *                  ZID :- Z1856513                                         *
 *                  Due Date :- ?                                           *
 *                  Portfolio :- 14                                          *
 *                  Description :- An application which uses munus and database *
 ****************************************************************************/

package edu.niu.cs.z1856513.databaseandmenus;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UpdateActivity extends AppCompatActivity
{
    private DatabaseManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //create the database
        manager = new DatabaseManager(this);

        //Create the View
        updateView();

    }//end onCreate

    public void updateView()
    {
        ArrayList<Candy> candies = manager.selectAll();
        //Check to see if there is info in the database/array list
        if(candies.size() > 0  )
        {
            ScrollView scrollView =  new ScrollView(this);

            GridLayout gridLayout = new GridLayout(this);

            //set the number of rows and columns for the grid
            gridLayout.setRowCount(candies.size());
            gridLayout.setColumnCount(4);//id,name,price,button

            //Create some arrays to hold info that will be placed on the screen
            TextView [] ids = new TextView[candies.size()];
            EditText [][] namesAndPrices = new EditText[candies.size()][2];

            Button [] buttons = new Button[candies.size()];

            ButtonHandler handler = new ButtonHandler();

            //Get the Dimensions on screen
            Point size = new Point();
            getWindowManager().getDefaultDisplay().getSize(size);
            int width =size.x;
            //Loop to process
            int sub = 0;
            for(Candy candy : candies)
            {
                //Create TextView
                ids[sub] = new TextView(this);
                ids[sub].setGravity(Gravity.CENTER);
                ids[sub].setText("" + candy.getId());
                //editText fields [0] name [1] price
                namesAndPrices[sub][0] = new EditText(this);
                namesAndPrices[sub][1] = new EditText(this);

                namesAndPrices[sub][0].setText(candy.getName());
                namesAndPrices[sub][1].setText("" + candy.getPrice());
                namesAndPrices[sub][1].setInputType(InputType.TYPE_CLASS_NUMBER);

                namesAndPrices[sub][0].setId( 10 * candy.getId());
                namesAndPrices[sub][1].setId(10 * candy.getId() + 1);

                buttons[sub] = new Button(this);
                buttons[sub].setText("Update");
                buttons[sub].setId(candy.getId());

                buttons[sub].setOnClickListener(handler);
                //Add the Items
                gridLayout.addView(ids[sub], (int)(width * 0.1), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(namesAndPrices[sub][0], (int)(width * .4), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(namesAndPrices[sub][1],(int)(width*.15),ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(buttons[sub],(int)(width*.35),ViewGroup.LayoutParams.WRAP_CONTENT);

                sub++;
            }//End For Loop
            scrollView.addView(gridLayout);

            //display the scroll view
            setContentView(scrollView);

        }//end if


    }//end UpdateView
    private class ButtonHandler implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            //get the name and the price from the editText Fields
            int candyId = v.getId();

            EditText nameET = findViewById(10 * candyId);
            EditText priceET = findViewById(10 * candyId + 1);

            String nameStr = nameET.getText().toString(),
                    priceStr = priceET.getText().toString();
            try
            {
                double price = Double.parseDouble(priceStr);

                manager.updateById(candyId,nameStr,price);

                Toast.makeText(UpdateActivity.this,"Candy updated: " + nameStr,Toast.LENGTH_SHORT).show();

                updateView();
            }
            catch (NumberFormatException nfe)
            {
                Toast.makeText(UpdateActivity.this,"Price Error", Toast.LENGTH_SHORT).show();


            }


        }//end onClick
    }//end ButtonHandler

}
