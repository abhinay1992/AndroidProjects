/****************************************************************************
 *                                                                          *
 *                  Name :- Abhinay Imandi                                  *
 *                  ZID :- Z1856513                                         *
 *                  Due Date :- ?                                           *
 *                  Portfolio :- 11                                         *
 *                  Description :- An application for TIC TAC TOE           *
 ****************************************************************************/

package edu.niu.cs.z1856513.tictactoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button[][] ticTacButtons;
    private TicTacToe gameTicTacToe;
    private TextView gameStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //Create the TicTacToe Game
        gameTicTacToe = new TicTacToe();
        buildGUI();
    }

    public void buildGUI()
    {
        //Get the width of the screen
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);

        //Calculate the width of 1/3 of the screen

        int width = size.x / TicTacToe.SIDE;
        //int height = size.y / TicTacToe.SIDE;

        //Create a gridLayout to hold the buttons for game

        GridLayout ticTacGrid = new GridLayout(this);

        //Set the number of rows and columns for the grid
        //Update the rows to add the game status
        ticTacGrid.setRowCount(TicTacToe.SIDE + 1);
        ticTacGrid.setColumnCount(TicTacToe.SIDE);

        //Create the two dimensional array of buttons
        ticTacButtons = new Button[TicTacToe.SIDE][TicTacToe.SIDE];

        //Handle button clicks
        ButtonHandler ticTacHandler = new ButtonHandler();

        //Add Buttons to the grid layout
        for(int row=0;row<TicTacToe.SIDE;row++)
        {
            for(int col=0;col<TicTacToe.SIDE;col++)
            {
                //Generate the button
                ticTacButtons[row][col] = new Button(this);
                ticTacButtons[row][col].setTextSize((int)(width * 0.2));
                ticTacButtons[row][col].setOnClickListener(ticTacHandler);
                ticTacGrid.addView(ticTacButtons[row][col],width,width);
            }
        }

        //Create a textView for game status
        gameStatus = new TextView(this);

        //Set size for the textView (specifications)
        GridLayout.Spec rowSpec = GridLayout.spec(TicTacToe.SIDE,1),
                        colSpec = GridLayout.spec(0,TicTacToe.SIDE);

        GridLayout.LayoutParams layoutParamsStatus = new GridLayout.LayoutParams(rowSpec,colSpec);

        //Attach the layout parameters to the text view
        gameStatus.setLayoutParams(layoutParamsStatus);

        //Create width and height for the text view
        gameStatus.setWidth(TicTacToe.SIDE * width);
        gameStatus.setHeight(width);

        //Gravity for the setview
        gameStatus.setGravity(Gravity.CENTER);

        //Set the background color
        gameStatus.setBackgroundColor(Color.CYAN);
        gameStatus.setText(gameTicTacToe.result());
        gameStatus.setTextSize((int)(width * 0.15));

        ticTacGrid.addView(gameStatus);

        // Display the view created on the screen
        setContentView(ticTacGrid);
    } //End BuildGUI

    //The Button Handler

    private class ButtonHandler implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            //Display a message to indicate the clicks
            Toast.makeText(MainActivity.this,"Button Handler clicked, view is "+v.getId(),Toast.LENGTH_SHORT).show();

            //Determine which button was clicked and update it
            for(int row=0;row<TicTacToe.SIDE;row++)
            {
                for(int col=0;col<TicTacToe.SIDE;col++)
                {
                    if(v == ticTacButtons[row][col])
                    {
                        update(row,col);
                    }
                }
            }
        }
    }

    public void update(int row,int column)
    {
        //Display a message
        //Toast.makeText(this,"Update : "+row+","+column,Toast.LENGTH_SHORT).show();

        //Put a symbol on the button
        //ticTacButtons[row][column].setText("X");

        int currentPlayer = gameTicTacToe.play(row,column);

        if(currentPlayer == 1)
            ticTacButtons[row][column].setText("X");
        else if(currentPlayer == 2)
            ticTacButtons[row][column].setText("O");

        //Check if the game is over

        if(gameTicTacToe.isGameOver())
        {
            if(gameTicTacToe.result().matches("Game Tied"))
            {
                gameStatus.setBackgroundColor(Color.RED);
            }
            else
            {
                gameStatus.setBackgroundColor(Color.GREEN);
            }
            gameStatus.setText(gameTicTacToe.result());
            enableButtons(false);
            showNewGameDialog();
        }
    }

    public void enableButtons(Boolean enable)
    {
        for(int row=0;row<TicTacToe.SIDE;row++)
            for(int col=0;col<TicTacToe.SIDE;col++)
                ticTacButtons[row][col].setEnabled(enable);
    }

    public void showNewGameDialog()
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Tic Tac Toe");
        alert.setMessage("Do you want to continue ?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                gameTicTacToe.resetGame();
                enableButtons(true);

                clearXO();

                gameStatus.setBackgroundColor(Color.CYAN);
                gameStatus.setText(gameTicTacToe.result());
            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                MainActivity.this.finish();
            }
        });

        alert.show();
    }

    public void clearXO()
    {
        for(int row=0;row<TicTacToe.SIDE;row++)
        {
            for(int col=0;col<TicTacToe.SIDE;col++)
            {
                ticTacButtons[row][col].setText("");
            }
        }
    }
}
