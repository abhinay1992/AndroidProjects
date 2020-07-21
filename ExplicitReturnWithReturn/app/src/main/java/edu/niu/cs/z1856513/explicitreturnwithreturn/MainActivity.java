/****************************************************************************
 *                                                                          *
 *                  Name :- Abhinay Imandi                                  *
 *                  ZID :- Z1856513                                         *
 *                  Due Date :- ?                                           *
 *                  Portfolio :- 4                                          *
 *                  Application :- 2                                        *
 *                  Description :- Explicit Intent activity to get the Name *
 ****************************************************************************/

package edu.niu.cs.z1856513.explicitreturnwithreturn;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView nameLabel;

    static final int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameLabel = (TextView)findViewById(R.id.nameLabel);
    }

    public void getName(View view)
    {
        Intent intent = new Intent(MainActivity.this,NameActivity.class);
        startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String nameReturned;

        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK)
        {
            nameReturned = "Your Name is "+data.getStringExtra("Name");
        }
        else
        {
            nameReturned = "Something went wrong!";
        }
        nameLabel.setText(nameReturned);
    }
}
