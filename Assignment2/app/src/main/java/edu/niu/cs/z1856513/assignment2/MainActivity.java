/************************************************************************************************
 *                                                                                              *
 *                  Name : Abhinay Imandi                                                       *
 *                                                                                              *
 *                  Zids :- Z1856513                                                            *
 *                                                                                              *
 *                  Assignment :- 2 (Quadratic Calculator)                                      *
 *                  Due Date :- 02/27/2019 11:59 PM                                             *
 *                  Description :- A sample application to calculate the roots of a             *
 *                                  quadratic equation                                          *
 ************************************************************************************************/

package edu.niu.cs.z1856513.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView disc,quad;
    private EditText avalue,bvalue,cvalue,result1,result2;
    private Button calc,clear;
    private double a,b,c,d,res1,res2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Decimal Format
        final DecimalFormat df = new DecimalFormat("#0.00");

        //Assigning the variables to the components on the display
        quad = (TextView)findViewById(R.id.quadEquation);
        disc = (TextView)findViewById(R.id.dricLabel);
        quad.setText(Html.fromHtml("ax<sup><small>2</small></sup>+bx+c"));

        avalue = (EditText)findViewById(R.id.avalue);
        avalue.requestFocus();
        bvalue = (EditText)findViewById(R.id.bvalue);
        cvalue = (EditText)findViewById(R.id.cvalue);
        result1 = (EditText)findViewById(R.id.firstX);
        result2 = (EditText)findViewById(R.id.secondX);

        calc = (Button)findViewById(R.id.xCalc);
        clear = (Button)findViewById(R.id.clearBtn);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Checking for null and zero values
                if(avalue.getText().toString().matches("")||bvalue.getText().toString().matches("")||cvalue.getText().toString().matches("")||
                        avalue.getText().toString().matches("0")||bvalue.getText().toString().matches("0")||cvalue.getText().toString().matches("0"))
                {
                    Toast.makeText(MainActivity.this,"Values Cannot be NULL or ZERO",Toast.LENGTH_LONG).show();
                }
                //Calculating the values of X
                else
                {
                    a = Double.parseDouble(avalue.getText().toString());
                    b = Double.parseDouble(bvalue.getText().toString());
                    c = Double.parseDouble(cvalue.getText().toString());

                    d = (b*b)-(4*a*c);
                    disc.setText("Discriminant = "+df.format(d));
                    if(d >= 0)
                    {
                        res1 = (-b+Math.sqrt(d))/(2*a);
                        res2 = (-b-Math.sqrt(d))/(2*a);

                        result1.setText(df.format(res1));
                        result2.setText(df.format(res2));
                    }
                    else
                    {
                        result1.setText("img");
                        result2.setText("img");
                    }
                }
            }
        });

        //Clearing the values when clear button is pressed
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                avalue.setText("");
                bvalue.setText("");
                cvalue.setText("");

                result1.setText("");
                result2.setText("");
                disc.setText("");
            }
        });
    }

    //Closing the application on back press
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(MainActivity.this,"Quadratic Calculator Closed",Toast.LENGTH_LONG).show();
        finish();
    }
}
