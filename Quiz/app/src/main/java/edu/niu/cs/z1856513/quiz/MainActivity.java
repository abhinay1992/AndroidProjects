package edu.niu.cs.z1856513.quiz;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends Activity {

    private String quizes[] = {"Quiz 1 - Week 2","Quiz 2 - Week 3","Quiz 3 - Week 4","Quiz 4 - Week 5","Quiz 5 - Week 7","Quiz 6 - Week 8","Quiz 7 - Week 9","Quiz 8 - Week 10","Quiz 9 - Week 11","Quiz 10 - Week 13","Quiz 11 - Week 14","Quiz 12 - Week 15"};
    private HashMap<String,Integer> quizesMap = new HashMap<>();
    private ScrollView quizScroll;
    private LinearLayout quizBtnLayout;
    private static int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadHashMaps();

        quizScroll = findViewById(R.id.quizBtnScroll);
        quizBtnLayout = findViewById(R.id.quizBtnLayout);

        Button[] quizBtns = new Button[quizes.length];
        for(;index<quizes.length;index++)
        {

            quizBtns[index] = new Button(this);
            quizBtns[index].setText(quizes[index]);
            quizBtns[index].setId(quizesMap.get(quizes[index]));
            quizBtns[index].setTextColor(Color.BLACK);
            quizBtns[index].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            quizBtns[index].setGravity(Gravity.CENTER);
            quizBtns[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(MainActivity.this,Integer.toString(v.getId()),Toast.LENGTH_LONG).show();
                }
            });
            quizBtnLayout.addView(quizBtns[index]);
        }
    }

    public void loadHashMaps()
    {
        quizesMap.put("Quiz 1 - Week 2",1);
        quizesMap.put("Quiz 2 - Week 3",2);
        quizesMap.put("Quiz 3 - Week 4",3);
        quizesMap.put("Quiz 4 - Week 5",4);
        quizesMap.put("Quiz 5 - Week 7",5);
        quizesMap.put("Quiz 6 - Week 8",6);
        quizesMap.put("Quiz 7 - Week 9",7);
        quizesMap.put("Quiz 8 - Week 10",8);
        quizesMap.put("Quiz 9 - Week 11",9);
        quizesMap.put("Quiz 10 - Week 13",10);
        quizesMap.put("Quiz 11 - Week 14",11);
        quizesMap.put("Quiz 12 - Week 15",12);
    }
}
