package com.example.dianamilton.h2go;


import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;



import java.util.List;

/**
 * Created by Csquad
 */

public class MyDatabase {

    private SQLiteDatabase database;
    private MyDbHelper dbHelper;


    public MyDatabase(Context context) {
        dbHelper = new MyDbHelper(context);
        open();
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }


    public User createStudent(String name, String email, String passCode, String phoneNumber, String address, String type) {
        return UserDAO.create( database,name,email,passCode,phoneNumber,address, type);

    }


    public void deleteStudent(User student) {
        UserDAO.delete(database, student);
    }


    public List<User> getAllStudents() {
        return UserDAO.getAllStudents(database);
    }


    public void updateStudent(User student) {

    }


    public User findStudentByName(String name) {
        return UserDAO.findByName(database, name);
    }


    public List<User> getAllStudentsWithMajor(String major) {
        return UserDAO.getAllByMajor(database, major);
    }
}
