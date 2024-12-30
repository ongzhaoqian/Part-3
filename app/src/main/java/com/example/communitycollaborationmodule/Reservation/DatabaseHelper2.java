package com.example.communitycollaborationmodule.Reservation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper2 extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "reservation.db";
    private static final int DATABASE_VERSION = 3;

    public DatabaseHelper2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE items (" +
                "id INTEGER PRIMARY KEY, " +
                "image TEXT, " +
                "name TEXT, " +
                "description TEXT," +
                "rating FLOAT, " +
                "location TEXT, " +
                "price TEXT " +
                ")";
        db.execSQL(createTable);

        db.execSQL("INSERT INTO items (image, name, description, rating, location, price) " +
                "VALUES ('strawberry_picking', 'Strawberry Picking', 'Enjoy strawberry picking experience at strawberry farm!', 4, 'Strawberry Farm', 'RM20/person')");
        db.execSQL("INSERT INTO items (image, name, description, rating, location, price) " +
                "VALUES ('farm_volunteer', 'Farm Volunteer', 'Volunteer while being in nature to have a taste of what we do in an urban farm.', 3, 'Happy Farm', 'Free')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 3) {
            db.execSQL("DROP TABLE IF EXISTS items");
            onCreate(db);
        }
    }

    public List<ReservationList> getAllItems() {
        List<ReservationList> items = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM items", null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                String image = cursor.getString(cursor.getColumnIndexOrThrow("image"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String description = cursor.getString(cursor.getColumnIndexOrThrow("description"));
                float rating = cursor.getFloat(cursor.getColumnIndexOrThrow("rating"));
                String location = cursor.getString(cursor.getColumnIndexOrThrow("location"));
                String price = cursor.getString(cursor.getColumnIndexOrThrow("price"));


                items.add(new ReservationList(image, name, description, rating, location, price));
            }
            cursor.close();
        }

        return items;
    }
}


