package edu.niu.cs.z1856513.pinviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;

public class MainActivity extends AppCompatActivity {

    private Pinview pin1,pin2;
    private String pinStr1,pinStr2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pin1 = findViewById(R.id.pinView1);
        pin2 = findViewById(R.id.pinView2);

        pin1.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean b) {
                pinStr1 = pin1.getValue().toString();
            }
        });

        pin2.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean b) {

                if(pinStr1.equalsIgnoreCase(pin2.getValue().toString()))
                {
                    Toast.makeText(MainActivity.this,"Matched",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Not Matched",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
