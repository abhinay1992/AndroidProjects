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
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "candyDB",
            TABLE_NAME = "CandyTable",
            ID = "id",
            NAME = "name",
            PRICE = "price";
    private static final int DATABASE_VERSION = 1;

    public DatabaseManager(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //String that contains SQL statement to create the database
        String sqlCreate = "create table " + TABLE_NAME + "( " + ID + " integer primary key autoincrement, " + NAME + " text, " + PRICE + " real )";

        //Create the database
        db.execSQL(sqlCreate);
    }//end onCreate

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //String that drops the old table if it exists
        String sqlDrop = "drop table if exists " + TABLE_NAME;

        //Drop the old table
        db.execSQL(sqlDrop);

        //Re-create the table
        onCreate(db);
    }//end onUpgrade

    public void insert( Candy candy)
    {
        //Get the Database
        SQLiteDatabase database = getWritableDatabase();

        //String to insert data into database
        String sqlInsert = "insert into " + TABLE_NAME + " values( null, '" + candy.getName() + "', " + "'" + candy.getPrice() + "' )";

        //Insert data into the database
        database.execSQL(sqlInsert);

        //Close the database
        database.close();

    }//end of insert
    public ArrayList<Candy> selectAll()
    {
        //String for geeting the information from the database
        String sqlQuery = "Select * from " + TABLE_NAME;

        //Get the Database
        SQLiteDatabase database = getWritableDatabase();

        //Create the cursor with all of the database information
        Cursor cursor = database.rawQuery(sqlQuery,null);

        //Create the arrayList that will eventually be returned
        ArrayList<Candy> candies = new ArrayList<>();

        //loop that will transfer information from cursor to arrayList
        while(cursor.moveToNext())
        {
            Candy currentCandy = new Candy(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getDouble(2));

            candies.add(currentCandy);
        }
        //Close the Database
        database.close();

        //return the candies
        return candies;
    }//end SelectAll


    public void deleteByID(int id)
    {
        //String with sql command
        String sqlDelete = "delete from " + TABLE_NAME + " where " + ID + " = " + id;

        //Get the database
        SQLiteDatabase database = getWritableDatabase();

        //delete teh candy from the database
        database.execSQL(sqlDelete);
        //close the database
        database.close();
    }//end deleteByID

    public void updateById( int currentId, String newName,double newPrice)
    {
        //Get the database
        SQLiteDatabase database = getWritableDatabase();

        //String with the sql command
        String sqlUpdate = "update " + TABLE_NAME + " set " + NAME  + " = '" + newName + "', " + PRICE + " = '" + newPrice + "'" + " where " + ID + " = " + currentId;

        //Update the database
        database.execSQL(sqlUpdate);

        //Close the database
        database.close();

    }//end UpdateById

    public Candy selectById( int currentId )
    {
        //Get the Database
        SQLiteDatabase database = getWritableDatabase();

        //String with sql command
        String sqlquery = " select * from " + TABLE_NAME + " where " + ID + " = " + currentId;

        //Create a cursor object
        Cursor cursor = database.rawQuery(sqlquery,null);

        //Create the candy Object with the info
        Candy candy = null;
        if(cursor.moveToFirst())
        {
            candy = new Candy(  Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getDouble(2));

        }
        return candy;

    }//end SelectById
}//end DatabaseManager
