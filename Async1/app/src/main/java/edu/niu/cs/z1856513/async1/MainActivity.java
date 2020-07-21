/****************************************************************************
 *                                                                          *
 *                  Name :- Abhinay Imandi                                  *
 *                  ZID :- Z1856513                                         *
 *                  Due Date :- ?                                           *
 *                  Portfolio :- 15 - 1                                     *
 *                  Description :- An application to use the Async tasks    *
 ****************************************************************************/

package edu.niu.cs.z1856513.async1;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Button downloadBtn;
    private ProgressBar downloadPB;
    private TextView downloadTV, callbackTV;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect the Data members to the screen widget
        downloadBtn = findViewById(R.id.downloadButton);

        downloadPB = findViewById(R.id.downloadProgressBar);

        downloadTV = findViewById(R.id.downloadTextView);

        callbackTV = findViewById(R.id.callbackTextView);


    }//end onCreate

    public void startDownload(View view)
    {
        //disable the download button
        downloadBtn.setEnabled(false);

        //Create asynctask object
        DownloadAsyncTask task = new DownloadAsyncTask();

        //Start the asyncTask
        task.execute();
    }//end StartDownload

    //Reset Button
    public  void doReset(View view)
    {

        //Reset the textViews
        downloadTV.setText(R.string.download_start_label);
        callbackTV.setText(R.string.callbacks_label);

        //Reset the progressBar
        downloadPB.setProgress(0);

        //unlock Screen Orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

    }

    //Inner Async task class
    private class DownloadAsyncTask extends AsyncTask<Void,Integer,Void>
    {
        int progressStatus;

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            //append a message to the current contents of the middle textview
            callbackTV.setText(callbackTV.getText() + "\n\nLock the Screen Orientation");
            //Lock the screen orientation
            int currentOrientation = getResources().getConfiguration().orientation;

            if(currentOrientation == Configuration.ORIENTATION_PORTRAIT)
            {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
            else
            {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
            //append another Message
            callbackTV.setText(callbackTV.getText() + "\nInvoke onPreExecute()");

            //Initialize the progress
            progressStatus = 0;

            //Indicate the downlaod progress
            downloadTV.setText(R.string.download_start_label);

            //append some messages before moving to doIn Background
            callbackTV.setText(callbackTV.getText() + "\nCompleted onPreExecute()");
            callbackTV.setText(callbackTV.getText() + "\nInvoke doInBackground()");
            callbackTV.setText(callbackTV.getText() + "\nDoing Background work...");
        }//end onPreExecute

        @Override
        protected Void doInBackground(Void... voids)
        {
            while(progressStatus < 100)
            {
                progressStatus += 2;
                //Display the progress
                publishProgress(progressStatus);

                //delay
                SystemClock.sleep(300);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values)
        {
            super.onProgressUpdate(values);

            //Update the progress
            downloadPB.setProgress(values[0] );

            //update the textView for the download
            downloadTV.setText("downloading " + values[0] + "%");


        }

        @Override
        protected void onPostExecute(Void aVoid)
        {

            super.onPostExecute(aVoid);
            //append messages
            callbackTV.setText(callbackTV.getText() + "\nCompleted Background Work");
            callbackTV.setText(callbackTV.getText() + "Invoke onPostExecute()");

            //Complete the download message
            downloadTV.setText("download complete");

            //re-enable the download button
            downloadBtn.setEnabled(true);
        }//end onPost

    }//end downloadAsync



}//end MainActivity

