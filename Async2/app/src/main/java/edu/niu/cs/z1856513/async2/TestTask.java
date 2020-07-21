package edu.niu.cs.z1856513.async2;

import android.os.AsyncTask;
import android.util.Log;

public class TestTask extends AsyncTask<Integer,Void,String>
{
    private MainActivity activity;
    public TestTask(MainActivity fromActivity )
    {
        Log.w("MainActivity", "Inside the constructor ");

        activity = fromActivity;

    }//end constructor

    @Override
    protected String doInBackground(Integer... integers)
    {
        Log.w("MainActivity","Inside doInBackground");
        //Create a string to be displayed
        String displayStr = "You favorite number is " + integers[0] + "\nChanged by asyncTask";
        return displayStr;
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        activity.updateView(s);
    }
}//end TestTask
