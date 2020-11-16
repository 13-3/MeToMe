package com.example.metome;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "MeToMe.db";
    private static final int DATABASE_VERSION = 9;





    public DatabaseHelper(@Nullable Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String queryUser = "CREATE TABLE " + Contract.Entry.TABLE_USER + " ("+
                Contract.Entry.COL_USER_USERNAME + " TEXT PRIMARY KEY, " +
                Contract.Entry.COL_IMAGE + " TEXT, " +
                Contract.Entry.COL_USER_NAME + " TEXT, " +
                Contract.Entry.COL_USER_EMAIL + " TEXT, " +
                Contract.Entry.COL_USER_PASSWORD + " TEXT);";



        db.execSQL(queryUser);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Contract.Entry.TABLE_USER);

        onCreate(db);

    }



    public long addUser(String image,String name, String username, String email, String password){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =  new ContentValues();

        cv.put(Contract.Entry.COL_USER_NAME,name);
        cv.put(Contract.Entry.COL_USER_USERNAME, username);
        cv.put(Contract.Entry.COL_USER_EMAIL, email);
        cv.put(Contract.Entry.COL_USER_PASSWORD,password);
        cv.put(Contract.Entry.COL_IMAGE,image);

        long res = db.insert(Contract.Entry.TABLE_USER,null,cv);
        return res;
    }

    public long addPhoto(String image)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =  new ContentValues();

        cv.put(Contract.Entry.COL_IMAGE,image);
        long res = db.insert(Contract.Entry.TABLE_USER,null,cv);

        return res;
    }



    public boolean checkUser(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        String [] columns = { Contract.Entry.COL_USER_USERNAME};

        String selection = Contract.Entry.COL_USER_USERNAME + "=?" + " and " + Contract.Entry.COL_USER_PASSWORD + "=?"
                ;
        String [] selectionArgs = {username , password};
        Cursor cursor = db.query(Contract.Entry.TABLE_USER, columns, selection,selectionArgs,null,null,null);
        int count = cursor.getCount();


        cursor.close();
        db.close();

        if(count>0)
            return true;
        else
            return false;

    }

    public String getProfilePhoto(String username)
    {
        String query = "SELECT " + Contract.Entry.COL_IMAGE + " FROM user WHERE username ='"+username+"'";

        SQLiteDatabase db = this.getReadableDatabase();
        String image = null;

        Cursor cursor = db.rawQuery(query,null);


       if(cursor.moveToFirst())
        {
            do{
                image = ""+cursor.getString(cursor.getColumnIndex("image"));

            }while (cursor.moveToNext());
        }

        return image;
    }


   /* public long addPiece(String image, String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Contract.Entry.COL_PIECE_IMAGE,image);
        cv.put(Contract.Entry.COL_PIECE_NAME,name);

        long res = db.insert(Contract.Entry.TABLE_PIECE,null,cv);

        return res;
    }


    public String getProfilePhoto(String username)
    {
        String image = null;
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT " + Contract.Entry.COL_IMAGE + " FROM " + Contract.Entry.TABLE_USER + " WHERE " +
                Contract.Entry.COL_USER_USERNAME + "=?" + username;


        Cursor cursor = db.rawQuery(selectQuery,null);


        if(cursor.moveToFirst())
        {
            do{
                image = ""+cursor.getInt(cursor.getColumnIndex(Contract.Entry.COL_IMAGE));

            }while (cursor.moveToNext());
        }

        return image;


*/
    }






