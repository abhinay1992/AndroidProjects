package edu.niu.cs.z1856513.explicitreturnwithreturn;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity {

    private EditText nameTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        nameTxt = (EditText)findViewById(R.id.nameTxt);
    }

    public void goBack(View view)
    {
        String nameInput = nameTxt.getText().toString();
        Intent intent = getIntent();

        intent.putExtra("Name",nameInput);
        ((Activity)view.getContext()).setResult(RESULT_OK,intent);
        finish();
    }
}
