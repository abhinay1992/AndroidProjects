/****************************************************************************
 *                                                                          *
 *                  Name :- Abhinay Imandi                                  *
 *                  ZID :- Z1856513                                         *
 *                  Due Date :- ?                                           *
 *                  Portfolio :- 12                                          *
 *                  Description :- An application to explain the functionality
 *                                  of threads in android                   *
 ****************************************************************************/

package edu.niu.cs.z1856513.threadscounter;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView counterText;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterText = findViewById(R.id.nameText);

        count = 0;

        //Create a thread and pass a runnable object
        Thread counterThread = new Thread( threadRun );

        //StartExecution
        counterThread.start();

    }//endOnCreate

    @Override
    protected void onStart() {
        super.onStart();

        //Reset counter to zero
        count = 0;
    }

    private Runnable threadRun = new Runnable() {

        private static final int DELAY = 500;
        @Override
        public void run() {

            while(true)
            {
                count++;
                try
                {
                    Thread.sleep(DELAY);
                }
                catch(InterruptedException ie)
                {
                    ie.printStackTrace();
                }

                //Update the user-interface thread by sending an empty message
                threadHandler.sendEmptyMessage(0);
            }//end while
        }//end run method
    };

    public Handler threadHandler = new Handler(){

        //Code the handler
        public void handleMessage(Message msg)
        {
            counterText.setText(Integer.toString(count));
        }
    };
}//endMainActivity
