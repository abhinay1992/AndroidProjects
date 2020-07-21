package z1856513.cs.niu.edu.caloriecalculator;

/************************************************************************************************
 *                                                                                              *
 *                  Name : Abhinay Imandi                                                       *
 *                                                                                              *
 *                  Zids :- Z1856513                                                            *
 *                                                                                              *
 *                  Portfolio :- 3 (Calorie Calculator)                                         *
 *                  Description :- A sample application to calculate the the calories for a     *
 *                                  Burger                                                      *
 ************************************************************************************************/

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity
{

    private RadioGroup patty,cheese;
    private CheckBox bacon;
    private SeekBar sauce;
    private TextView calories;

    private Burger burger;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing the components to the layout created

        patty = (RadioGroup)findViewById(R.id.radioBtnGroup);
        cheese = (RadioGroup)findViewById(R.id.cheeseRadioBtnGroup);

        bacon = (CheckBox)findViewById(R.id.baconCheckBox);

        sauce = (SeekBar)findViewById(R.id.sauceSeekBar);

        calories = (TextView)findViewById(R.id.calorieLabel);

        burger = new Burger();

        displayCalories();

        patty.setOnCheckedChangeListener(pattyListener);

        cheese.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch(checkedId)
                {
                    case R.id.noCheese: burger.setCheeseCalories(0);
                                        break;

                    case R.id.cheddarCheese : burger.setCheeseCalories(Burger.CHEDDAR);
                                              break;

                    case R.id.mozzarellaCheese : burger.setCheeseCalories(Burger.MOZZ);
                                                 break;

                }

                displayCalories();
            }
        });

        //set up bacon listener
        bacon.setOnClickListener(baconListener);

        // setup listener for seekbar sauce
        sauce.setOnSeekBarChangeListener(sauceListener);

    }//end OnCreate

    private SeekBar.OnSeekBarChangeListener sauceListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            burger.setSauceCalories(seekBar.getProgress());
            displayCalories();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private View.OnClickListener baconListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (((CheckBox) v).isChecked())
                burger.setBaconCalories(true);
            else
                burger.setBaconCalories(false);

            displayCalories();
        }
    };
    private RadioGroup.OnCheckedChangeListener pattyListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            switch(checkedId)
            {
                case R.id.beefPattyRadioBtn : burger.setPattyCalories(Burger.BEEF);
                                              break;

                case R.id.turkeyPattyRadioBtn : burger.setPattyCalories(Burger.TURKEY);
                                                break;

                case R.id.veggiePattyRadioBtn : burger.setPattyCalories(Burger.VEGGIE);
                                                break;
            }

            displayCalories();
        }
    };

    private void displayCalories()
    {
        calories.setText("Calories: "+burger.getTotalCal());
    }
}
