/****************************************************************************
 *                                                                          *
 *                  Name :- Abhinay Imandi                                  *
 *                  ZID :- Z1856513                                         *
 *                  Due Date :- ?                                           *
 *                  Portfolio :- 5                                          *
 *                  Description :- An application to display                *
 *                                  the working of spinners in android      *
 ****************************************************************************/

package edu.niu.cs.z1856513.spinners;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner xmlSpinner,classSpinner,listSpinner;
    private List<String> listValues = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listValues.add("Beer");
        listValues.add("Whisky");
        listValues.add("Vodka");
        listValues.add("Wine");
        listValues.add("Gin");

        xmlSpinner = (Spinner)findViewById(R.id.xmlSpinner);
        ArrayAdapter<CharSequence> firstAdapt = ArrayAdapter.createFromResource(getApplicationContext(),R.array.spinnerArray,R.layout.spinner_view);
        xmlSpinner.setAdapter(firstAdapt);
        xmlSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),"The selection is : "+parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        classSpinner = (Spinner)findViewById(R.id.classSpinner);
        ArrayAdapter<String> secondAdapt = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_view,SpinnerClass.valueArray);
        classSpinner.setAdapter(secondAdapt);
        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),"The Selection is :- "+parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listSpinner = (Spinner)findViewById(R.id.listSpinner);
        ArrayAdapter<String> thirdAdapt = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_view,listValues);
        listSpinner.setAdapter(thirdAdapt);
        listSpinner.setOnItemSelectedListener(SpinnerAdapt);
    }

    AdapterView.OnItemSelectedListener SpinnerAdapt = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            Toast.makeText(MainActivity.this,"The Selection is : "+parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}
