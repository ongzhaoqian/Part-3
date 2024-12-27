package com.example.communitycollaborationmodule;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "connection.db";
    private static final int DATABASE_VERSION = 3;  // Increment version to trigger onUpgrade

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE items (" +
                "id INTEGER PRIMARY KEY, " +
                "image TEXT, " +// Store the drawable resource name
                "name TEXT, " +
                "rating FLOAT, " +
                "distance FLOAT, " +
                "product TEXT, " +
                "price TEXT, " +
                "image2 TEXT" +
                ")";
        db.execSQL(createTable);

        // Insert initial data with drawable resource names as image references
        db.execSQL("INSERT INTO items (image, name, rating, distance, product, price, image2) " +
                "VALUES ('farmp3', 'Happy Farm', '4', '15', 'Kangkung', 'RM2.70/250g', 'kangkung')");

        db.execSQL("INSERT INTO items (image, name, rating, distance, product, price, image2) " +
                "VALUES ('fresh_supermarket','Happy Farm','3','15','Kangkung','RM2.70/250g','kangkung')");


    }

    private String getColumnValue(Cursor cursor, String columnName) {
        int columnIndex = cursor.getColumnIndex(columnName);
        if (columnIndex != -1 && !cursor.isNull(columnIndex)) {
            return cursor.getString(columnIndex);
        }
        return null; // Return null if column doesn't exist or value is null
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 3) {
            db.execSQL("DROP TABLE IF EXISTS items");
            onCreate(db);
        }
    }


    // Method to search items by name
    public List<ConnectionList> searchItems(String query) {
        List<ConnectionList> items = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM items WHERE name LIKE ?", new String[]{"%" + query + "%"});

        if (cursor != null) {
            while (cursor.moveToNext()) {
                // Check if the column indices are valid before accessing them
                int idIndex = cursor.getColumnIndex("id");
                int imageIndex = cursor.getColumnIndex("image");
                int nameIndex = cursor.getColumnIndex("name");
                int ratingIndex = cursor.getColumnIndex("rating");
                int distanceIndex = cursor.getColumnIndex("distance");
                int productIndex = cursor.getColumnIndex("product");
                int priceIndex = cursor.getColumnIndex("price");
                int image2Index = cursor.getColumnIndex("image2");

                //Handle invalid column index cases
                int id = (idIndex >= 0) ? cursor.getInt(idIndex) : -1;
                String image = (nameIndex >= 0) ? cursor.getString(nameIndex) : "Unknown Name";
                String name = (imageIndex >= 0) ? cursor.getString(imageIndex) : "Unknown Image";
                Float rating = (ratingIndex >= 0) ? cursor.getFloat(ratingIndex) : -1;
                Float distance = (distanceIndex >= 0) ? cursor.getFloat(distanceIndex) : -1;
                String product = (productIndex >= 0) ? cursor.getString(productIndex) : "Unknown Protein Content";
                String price = (priceIndex >= 0) ? cursor.getString(priceIndex) : "No Description";
                String image2 = (image2Index >= 0) ? cursor.getString(image2Index) : "Unknown Ingredients";

                // Add the item to the list
                items.add(new ConnectionList(image, name, rating, distance, product, price, image2));
            }
            cursor.close();
        }

        return items;

    }
}

