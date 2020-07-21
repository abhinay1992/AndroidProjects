/****************************************************************************
 *                                                                          *
 *                  Name :- Abhinay Imandi                                  *
 *                  ZID :- Z1856513                                         *
 *                  Due Date :- ?                                           *
 *                  Portfolio :- 4                                          *
 *                  Application :- 3                                        *
 *                  Description :-  Implicit Intent Calls                   *
 *                                  to make a call, open browser and take a *
 *                                  picture                                 *
 ****************************************************************************/

package edu.niu.cs.z1856513.implicitintentcall;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView picImg;

    static final int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        picImg = (ImageView)findViewById(R.id.imgView);
    }

    public void doBrowser(View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cs.niu.edu"));
        startActivity(browserIntent);
    }

    public void doPhone(View view)
    {
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:8155933586"));
        startActivity(phoneIntent);
    }

    public void doPic(View view)
    {
        Intent picIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(picIntent.resolveActivity(getPackageManager())!=null)
        {
            startActivityForResult(picIntent,REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK)
        {
            Bundle extras = data.getExtras();
            Bitmap imgBM = (Bitmap)extras.get("data");
            picImg.setImageBitmap(imgBM);
            Toast.makeText(MainActivity.this,"Successful",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(MainActivity.this,"Un-Successful",Toast.LENGTH_LONG).show();
        }
    }
}
