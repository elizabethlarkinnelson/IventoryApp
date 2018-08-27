package com.example.enelson.inventoryapp.data;

import android.provider.BaseColumns;

public final class InventoryContract {

    private InventoryContract(){}

    public static final class InventoryEntry implements BaseColumns {

        /**Name of database table for inventory*/
        public final static String TABLE_NAME = "inventory";

        /**
         * Unique ID for inventory
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;


        /**
         *
         */

    }
}
