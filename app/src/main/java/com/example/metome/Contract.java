package com.example.metome;

import android.provider.BaseColumns;

public class Contract {
    public Contract() {
    }

    public static final class Entry implements BaseColumns

    {

        public static final String TABLE_USER = "user";
        public static final String COL_USER_NAME = "full_name";
        public static final String COL_USER_USERNAME= "username";
        public static final String COL_USER_EMAIL = "email";
        public static final String COL_USER_PASSWORD = "password";
        public static final String COL_IMAGE = "image";


    }
}
