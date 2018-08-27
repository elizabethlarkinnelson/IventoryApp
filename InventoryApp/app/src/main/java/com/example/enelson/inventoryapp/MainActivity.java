package com.example.enelson.inventoryapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.enelson.inventoryapp.data.InventoryContract;
import com.example.enelson.inventoryapp.data.InventoryDbHelper;

public class MainActivity extends AppCompatActivity {

    private InventoryDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDbHelper = new InventoryDbHelper(this);
    }

    @Override
    protected void onStart(){
        super.onStart();
        insertInventory();
        displayDatabseInfo();
    }

    private void displayDatabseInfo(){
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + InventoryContract.InventoryEntry.TABLE_NAME, null);
        try {
            TextView displayView = (TextView) findViewById(R.id.database_view);
            displayView.setText("Number of db rows " + cursor.getCount());
        } finally {
            cursor.close();
        }
    }

    private void insertInventory() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(InventoryContract.InventoryEntry.COLUMN_PRODUCT_NAME, "Painting");
        values.put(InventoryContract.InventoryEntry.COLUMN_PRODUCT_PRICE, 8);
        values.put(InventoryContract.InventoryEntry.COLUMN_PRODUCT_QUANTITY, 1);
        values.put(InventoryContract.InventoryEntry.COLUMN_PRODUCT_SUPPLIER_NAME, "Art for days");
        values.put(InventoryContract.InventoryEntry.COLUMN_PRODUCT_SUPPLIER_PHONE, "888-888-8888");

        long newRowID = db.insert(InventoryContract.InventoryEntry.TABLE_NAME, null, values);

    }

}
