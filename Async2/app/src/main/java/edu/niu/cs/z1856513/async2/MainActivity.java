package edu.niu.cs.z1856513.async2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }//end onCreate
    public void doChange(View view)
    {
        //Get the info from editText
        EditText dataET = findViewById(R.id.dataEditText);
        int faveNum = Integer.parseInt(dataET.getText().toString());

        Log.w("MainActivity","Create the testtask object");
        TestTask testTask = new TestTask(this);
        Log.w("MainActivity","Starting TestTask");

        testTask.execute(faveNum);


    }//end doChange

    //Method to update the screen
    public void updateView(String message)
    {
        Log.w("MainActivity","In updateview: " + message);

        TextView messageTV = findViewById(R.id.messageTextView);

        messageTV.setText(message);

    }//end updateView

}//
