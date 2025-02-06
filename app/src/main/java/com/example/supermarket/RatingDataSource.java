package com.example.supermarket;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class RatingDataSource {

    private SQLiteDatabase database;

    private RatingDBHelper dbHelper;

    public RatingDataSource(Context context){
        dbHelper = new RatingDBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }
    public boolean checkRating(String m, String a){
        boolean didSucceed = false;
        try{
            String query = "Select * from rating where market = '" + m + "' and marketaddress = '" + a + "'";
            Cursor cursor = database.rawQuery(query, null);

            if(cursor.getCount() > 0){
                didSucceed = true;
            }
            cursor.close();
        }
        catch (Exception e){
            didSucceed = false;
        }
        return didSucceed;
    }

    public boolean insertRating(Rating r){
        boolean didSucceed = false;
        try{
            ContentValues initialValues = new ContentValues();

            initialValues.put("marketaddress", r.getMarketAddress());
            initialValues.put("market", r.getMarket());
            initialValues.put("liquor", r.getLiquor());
            initialValues.put("produce", r.getProduce());
            initialValues.put("meat", r.getMeat());
            initialValues.put("cheese", r.getCheese());
            initialValues.put("checkout", r.getCheckout());

            didSucceed = database.insert("rating", null, initialValues) > 0;
        }
        catch (Exception e){

        }
        return didSucceed;
    }
    public long getRatingId(String m, String a){
        long id = -1;
        try{
            String query = "Select _id from rating where market = '" + m + "' and marketaddress = '" + a + "'";
            Cursor cursor = database.rawQuery(query, null);

            cursor.moveToFirst();
            id = cursor.getLong(0);
            cursor.close();
        }
        catch (Exception e){
            id = -1;
        }
        return id;
    }
    public boolean updateRating(Rating r){
        boolean didSucceed = false;
        try{
            Long rowId = (long) r.getRatingID();
            ContentValues updateValues = new ContentValues();

            updateValues.put("marketaddress", r.getMarketAddress());
            updateValues.put("market", r.getMarket());
            updateValues.put("liquor", r.getLiquor());
            updateValues.put("produce", r.getProduce());
            updateValues.put("meat", r.getMeat());
            updateValues.put("cheese", r.getCheese());
            updateValues.put("checkout", r.getCheckout());

            didSucceed = database.update("rating", updateValues, "_id=" + rowId, null) > 0;
        }
        catch (Exception e){

        }
        return didSucceed;
    }

    public int getLastRatingId(){
        int lastId = -1;
        try{
            String query = "Select MAX(_id) from rating";
            Cursor cursor = database.rawQuery(query, null);

            cursor.moveToFirst();
            lastId = cursor.getInt(0);
            cursor.close();
        }
        catch (Exception e){
            lastId = -1;
        }
        return lastId;
    }


}
