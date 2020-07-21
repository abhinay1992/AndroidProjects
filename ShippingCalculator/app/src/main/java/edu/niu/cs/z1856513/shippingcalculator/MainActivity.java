/****************************************************************************
 *                                                                          *
 *                  Name :- Abhinay Imandi                                  *
 *                  ZID :- Z1856513                                         *
 *                  Due Date :- ?                                           *
 *                  Portfolio :- 4
 *                  Application :- 1*
 *                  Description :- An application to calculate the          *
 *                                  the shipping cost using EditText and    *
 *                                  TextViews                               *
 ****************************************************************************/

package edu.niu.cs.z1856513.shippingcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{

    //Object for shippingItem class
    shippingItem si;
    TextView baseCost,addedCost,totalCost;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect EditText and TextViews to objects on the screen
        final EditText ounces = (EditText)findViewById(R.id.weightEditText);

        baseCost = (TextView)findViewById(R.id.baseCostTextView);
        addedCost = (TextView)findViewById(R.id.addedCostTextView);
        totalCost = (TextView)findViewById(R.id.totalCostTextView);

        //Creating an object for shippingItem class
        si = new shippingItem();

        ounces.requestFocus();
        ounces.addTextChangedListener( weightWatcher );
    } //end of OnCreate Method

    TextWatcher weightWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try
            {
                si.setWeight(Integer.parseInt(s.toString()));
            }
            catch(NumberFormatException nfe)
            {
                si.setWeight(0);
            }

            DecimalFormat df = new DecimalFormat("#0.00");

            //set the TextViews with the costs

            baseCost.setText("$"+df.format(si.getBaseCost()));
            addedCost.setText("$"+df.format(si.getAddedCost()));
            totalCost.setText("$"+df.format(si.getTotalCost()));

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }; //End of weightWatcher

    public void getHelp(View view)
    {
        Intent helpIntent = new Intent(MainActivity.this,HelpActivity.class);

        startActivity(helpIntent);
    }
} //End of ActivityMain Class
