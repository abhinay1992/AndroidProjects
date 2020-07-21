package edu.niu.cs.z1856513.exam1;

/************************************************************************************************
 *                                                                                              *
 *                  Name :- Abhinay Imandi                                                      *
 *                                                                                              *
 *                  Zid  :- Z1856513                                                            *
 *                                                                                              *
 *                  Exam :- 1 (Area Calculator)                                                 *
 *                  Due Date :- 03/25/2019 11:59 PM                                             *
 *                  Description :- A simple application to calculate the area of Circle         *
 *                                  Triangle and Ellipse                                        *
 ************************************************************************************************/

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private RadioGroup shapes;
    private Button calculateArea;
    private TextView result;
    private String shape=null;

    static final int REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shapes = findViewById(R.id.radioGrp);
        calculateArea = findViewById(R.id.calculateBtn);
        result = findViewById(R.id.resultView);

        shapes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId)
                {
                    case R.id.triangleRadioButton : shape = "Triangle";
                                                    break;

                    case R.id.circleRadioButton : shape = "Circle";
                                                  break;

                    case R.id.ellipseRadioButton : shape = "Ellipse";
                                                   break;

                    default : shape = null;
                              break;
                }
            }
        });

        calculateArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(shape!=null)
                {
                    Intent intent = new Intent(MainActivity.this,CalculateActivity.class);
                    intent.putExtra("Shape",shape);
                    startActivityForResult(intent,REQUEST_CODE);
                }
                else
                {
                    Toast.makeText(v.getContext(),"Please make a selection",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String resultRtn;

        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK)
        {
            resultRtn = data.getStringExtra("Result");
            result.setText("The area of "+shape+" is : "+resultRtn);
        }
        else
        {
            result.setText("Something went wrong!!!");
        }
    }
}
