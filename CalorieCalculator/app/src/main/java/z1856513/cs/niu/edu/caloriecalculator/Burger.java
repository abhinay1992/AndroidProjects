package z1856513.cs.niu.edu.caloriecalculator;

/************************************************************************************************
 *                                                                                              *
 *                  Name : Abhinay Imandi                                                       *
 *                                                                                              *
 *                  Zids :- Z1856513                                                            *
 *                                                                                              *
 *                  Portfolio :- 3 (Calorie Calculator)                                         *
 *                  Description :- Burger class to hold the calories values                     *                                                      *
 ************************************************************************************************/

public class Burger
{
    //Constants

    static final int BEEF = 90,
                     TURKEY = 170,
                     VEGGIE = 150,
                     CHEDDAR = 113,
                     MOZZ = 78,
                     BACON = 86;

    //Data Members
    private int pattyCalories, cheeseCalories, sauceCalories, baconCalories;

    //Constructor
    public Burger()
    {
        pattyCalories = BEEF;
        cheeseCalories = 0;
        baconCalories = 0;
        sauceCalories = 0;
    }//End Burger Constructor

    //Setters
    public void setPattyCalories(int pattyCalories) {
        this.pattyCalories = pattyCalories;
    }

    public void setCheeseCalories(int cheeseCalories) {
        this.cheeseCalories = cheeseCalories;
    }

    public void setSauceCalories(int sauceCalories) {
        this.sauceCalories = sauceCalories;
    }

    public void setBaconCalories(boolean baconCalories) {

        if(baconCalories)
        {
            this.baconCalories = BACON;
        }
        else
        {
            this.baconCalories = 0;
        }
    }

    //Method for Calculating the total number of calories
    public int getTotalCal()
    {

        return (pattyCalories+sauceCalories+baconCalories+cheeseCalories);

    }//End getTotalCal()

} //End Burger Class
