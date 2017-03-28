package com.example.dianamilton.h2go;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Csquad
 */

public class UserDAO {
    // Database table column names
    public static final String TABLE_NAME = "user table";
    public static final String COLUMN_PASSCODE = "passcode";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONENUMBER = "phone number";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_TYPE = "type";
    public static final String[] allColumns = { UserDAO.COLUMN_PASSCODE,
            UserDAO.COLUMN_NAME, UserDAO.COLUMN_EMAIL, UserDAO.COLUMN_PHONENUMBER, UserDAO.COLUMN_ADDRESS, UserDAO.COLUMN_TYPE  };
    private static final int PASSCODE_NUMBER = 0;
    private static final int NAME_NUMBER = 1;
    private static final int EMAIL_NUMBER = 2;
    private static final int PHONENUMBER_NUMBER = 3;
    private static final int ADDRESS_NUMBER = 4;
    private static final int TYPE_NUMBER = 5;

    // Database creation SQL statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_NAME
            + "("
            + COLUMN_PASSCODE + " integer primary key autoincrement, "
            + COLUMN_NAME+ " text not null, "
            + COLUMN_EMAIL + " text not null"
            + COLUMN_PHONENUMBER + " text not null, "
            + COLUMN_ADDRESS + " text not null"
            + COLUMN_TYPE + " text not null"
            + ");";

    public static void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion,
                                 int newVersion) {
        Log.w(UserDAO.class.getName(), "Upgrading database from version "
                + oldVersion + " to " + newVersion
                + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(database);
    }

    public static User create(SQLiteDatabase database, String name, String email, String passCode, String phoneNumber, String address, String type) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASSCODE, passCode);
        values.put(COLUMN_PHONENUMBER, phoneNumber);
        values.put(COLUMN_ADDRESS, address);
        values.put(COLUMN_TYPE, type);


        long insertId = database.insert(TABLE_NAME, null,
                values);

        Log.d("APP", "Inserted User: " + insertId);

        Cursor cursor = database.query(TABLE_NAME,
                allColumns, COLUMN_PASSCODE + " = " + insertId, null,
                null, null, null);

        cursor.moveToFirst();

        User student = cursorToUser(cursor);
        cursor.close();
        return student;
    }

    private static User cursorToUser(Cursor cursor) {
        User student = new User();
        student.setName(cursor.getString(NAME_NUMBER));
        student.setPasscode(cursor.getString(PASSCODE_NUMBER));
        student.setEmail(cursor.getString(EMAIL_NUMBER));
        student.setNumber(cursor.getString(PHONENUMBER_NUMBER));
        student.setAddress(cursor.getString(ADDRESS_NUMBER));
        student.setType(cursor.getString(TYPE_NUMBER));

        return student;
    }


    public static List<User> getAllStudents(SQLiteDatabase database) {
        List<User> students = new ArrayList<>();
        Cursor cursor = database.query(TABLE_NAME,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            User student = cursorToUser(cursor);
            students.add(student);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();

        Log.d("APP", "All Students: " + students.toString());

        return students;
    }

    public static void delete(SQLiteDatabase database, User student) {
        String id = student.getPasscode();
        database.delete(TABLE_NAME, COLUMN_PASSCODE + " = " + id, null);
    }

    public static User findByName(SQLiteDatabase database, String name) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME + " ='" + name;

        Cursor  cursor = database.rawQuery(query,null);

        User student = null;

        if (cursor != null) {
            cursor.moveToFirst();

            student = cursorToUser(cursor);

            cursor.close();

        }



        return student;
    }

    public static List<User> getAllByMajor(SQLiteDatabase database, String major) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_EMAIL + " ='" + major;

        Cursor  cursor = database.rawQuery(query,null);

        List<User> users = new ArrayList<>();

        if (cursor != null) {
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                User student = cursorToUser(cursor);
                users.add(student);
                cursor.moveToNext();
            }

            cursor.close();
        }

        return users;

    }
}
