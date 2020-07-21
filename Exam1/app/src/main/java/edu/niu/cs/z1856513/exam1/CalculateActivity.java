package edu.niu.cs.z1856513.exam1;

/************************************************************************************************
 *                                                                                              *
 *                  Name :- Abhinay Imandi                                                      *
 *                                                                                              *
 *                  Zid  :- Z1856513                                                            *
 *                                                                                              *
 *                  Exam :- 1 (Area Calculator)                                                 *
 *                  Due Date :- 03/25/2019 11:59 PM                                             *
 *                  Description :- Second Activity which asks user for input and calculates     *
 *                                  the area                                                    *
 ************************************************************************************************/

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CalculateActivity extends Activity {

    private LinearLayout circle,triangle,ellipse;
    private Button returnCalc;
    private TextView title;
    private EditText radius,base,height,semiMinor,semiMajor;
    private final double PI = 3.14159;
    private double r=0.0,b=0.0,h=0.0,sMi=0.0,sMj=0.0,res=0.0;
    private Intent intent;
    private ImageView circleImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        final DecimalFormat df = new DecimalFormat("#0.00000");

        intent = getIntent();

        circle = findViewById(R.id.circleLayout);
        triangle = findViewById(R.id.triangleLayout);
        ellipse = findViewById(R.id.ellipseLayout);
        returnCalc = findViewById(R.id.calReturn);
        title = findViewById(R.id.areaTitle);
        radius = findViewById(R.id.radiusTxt);
        base = findViewById(R.id.baseTxt);
        height = findViewById(R.id.heightTxt);
        semiMajor = findViewById(R.id.semiMajorTxt);
        semiMinor = findViewById(R.id.semiMinorTxt);
        circleImg = findViewById(R.id.circleAreaImg);

        title.setText(intent.getStringExtra("Shape"));
        returnCalc.setText("Calculate the "+intent.getStringExtra("Shape")+" Area");
        switch(intent.getStringExtra("Shape"))
        {
            case "Circle" : circle.setVisibility(View.VISIBLE);
                            circleImg.setVisibility(View.VISIBLE);
                            break;

            case "Triangle" : triangle.setVisibility(View.VISIBLE);
                              break;

            case "Ellipse" : ellipse.setVisibility(View.VISIBLE);
                             break;
        }

        returnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean start = false;
                switch(intent.getStringExtra("Shape"))
                {
                    case "Circle" : if(radius.getText().toString().matches(""))
                                    {
                                        Toast.makeText(v.getContext(),"Radius value cannot be empty",Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                    {
                                        r = Double.parseDouble(radius.getText().toString());
                                        res = PI * r * r;
                                        start = true;
                                    }
                                    break;

                    case "Triangle" : if(base.getText().toString().matches("")||height.getText().toString().matches(""))
                                      {
                                          Toast.makeText(v.getContext(),"Values cannot be empty!!\n Please enter the Base and Height for Triangle",Toast.LENGTH_SHORT).show();
                                      }
                                      else
                                      {
                                          b = Double.parseDouble(base.getText().toString());
                                          h = Double.parseDouble(height.getText().toString());
                                          res = (b * h)/2;
                                          start = true;
                                      }
                                      break;

                    case "Ellipse" : if(semiMajor.getText().toString().matches("")||semiMinor.getText().toString().matches(""))
                                     {
                                         Toast.makeText(v.getContext(),"Values cannot be empty!!\n Please enter the Semi-Major and Semi-Minor axis for Ellipse",Toast.LENGTH_SHORT).show();
                                     }
                                     else
                                     {
                                         sMj = Double.parseDouble(semiMajor.getText().toString());
                                         sMi = Double.parseDouble(semiMinor.getText().toString());
                                         res = PI * sMi * sMj;
                                         start = true;
                                     }
                                     break;
                }
                if(start)
                {
                    String resStr = df.format(res);
                    intent.putExtra("Result",resStr);
                    ((Activity)v.getContext()).setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }
}
