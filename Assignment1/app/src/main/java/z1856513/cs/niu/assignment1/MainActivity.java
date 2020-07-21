/************************************************************************************************
 *                                                                                              *
 *                  Name : Abhinay Imandi                                                       *
 *                                                                                              *
 *                  Zids :- Z1856513                                                            *
 *                                                                                              *
 *                  Assignment :- 1                                                             *
 *                  Due Date :- 02/08/2019 11:59 PM                                             *
 *                  Description :- A sample application to demo the usage of OnClick Listener   *
 ************************************************************************************************/

package z1856513.cs.niu.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int clickCnt = 0;
    private Button clickBtn,exitBtn;
    private TextView greetTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing the buttons and textview

        clickBtn = (Button)findViewById(R.id.clickBtn);
        exitBtn = (Button)findViewById(R.id.exitBtn);
        greetTxt = (TextView)findViewById(R.id.greetText);

        // Adding OnClickListener to the clickBtn
        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(clickCnt == 0)
                {
                    greetTxt.setText("Welcome! You can click the button 10 times");
                    clickCnt++;
                }
                else if(clickCnt>0 && clickCnt<10)
                {
                    greetTxt.setText("You can click the button "+(10-clickCnt)+" more times");
                    clickCnt++;
                }
                else
                {
                    greetTxt.setText("Thank you. Have a nice day.");
                    exitBtn.setEnabled(true);
                    clickBtn.setEnabled(false);
                }
            }
        }); // End of clickBtn

        //Adding the OnClickListener to the exitBtn
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                clickCnt=0;
                System.exit(0);
            }
        }); //End of ExitBtn
    }
}
