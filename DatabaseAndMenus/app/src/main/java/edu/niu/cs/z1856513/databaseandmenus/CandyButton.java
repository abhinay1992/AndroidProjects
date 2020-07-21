/****************************************************************************
 *                                                                          *
 *                  Name :- Abhinay Imandi                                  *
 *                  ZID :- Z1856513                                         *
 *                  Due Date :- ?                                           *
 *                  Portfolio :- 14                                          *
 *                  Description :- An application which uses munus and database *
 ****************************************************************************/

package edu.niu.cs.z1856513.databaseandmenus;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;

public class CandyButton extends AppCompatButton {
    private  Candy candy;
    public  CandyButton(Context context,Candy newCandy)
    {
        super(context);
        candy = newCandy;

    }
    public double getPrice()
    {
        return candy.getPrice();
    }

}

