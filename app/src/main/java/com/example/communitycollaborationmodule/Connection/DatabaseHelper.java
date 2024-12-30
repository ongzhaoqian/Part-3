package com.example.communitycollaborationmodule.Connection;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "connection.db";
    private static final int DATABASE_VERSION = 3;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE items (" +
                "id INTEGER PRIMARY KEY, " +
                "image TEXT, " +
                "name TEXT, " +
                "rating FLOAT, " +
                "distance FLOAT, " +
                "product TEXT, " +
                "price TEXT, " +
                "image2 TEXT" +
                ")";
        db.execSQL(createTable);

        db.execSQL("INSERT INTO items (image, name, rating, distance, product, price, image2) " +
                "VALUES ('farmp3', 'Happy Farm', 4, 15, 'Kangkung', 'RM2.70/250g', 'kangkung')");
        db.execSQL("INSERT INTO items (image, name, rating, distance, product, price, image2) " +
                "VALUES ('fresh_supermarket', 'Fresh Supermarket', 5, 12, 'Apple', 'RM6.00/kg', 'sellapple')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 3) {
            db.execSQL("DROP TABLE IF EXISTS items");
            onCreate(db);
        }
    }

    public List<ConnectionList> getAllItems() {
        List<ConnectionList> items = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM items", null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                String image = cursor.getString(cursor.getColumnIndexOrThrow("image"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                float rating = cursor.getFloat(cursor.getColumnIndexOrThrow("rating"));
                float distance = cursor.getFloat(cursor.getColumnIndexOrThrow("distance"));
                String product = cursor.getString(cursor.getColumnIndexOrThrow("product"));
                String price = cursor.getString(cursor.getColumnIndexOrThrow("price"));
                String image2 = cursor.getString(cursor.getColumnIndexOrThrow("image2"));

                items.add(new ConnectionList(image, name, rating, distance, product, price, image2));
            }
            cursor.close();
        }

        return items;
    }
}

