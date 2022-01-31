package com.example.u4t8database.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TodoListDBHelper extends SQLiteOpenHelper {
    private static TodoListDBHelper instanceDBHelper;
/*
    public TodoListDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
*/

    public static synchronized  TodoListDBHelper getInstance(Context context) {
        // instance must be unique
        if (instanceDBHelper == null ) {
            instanceDBHelper = new TodoListDBHelper(context.getApplicationContext());
        }
        return instanceDBHelper;
    }

     // Constructor should be private to prevent direct instantiation.
    private TodoListDBHelper(Context context) {
        super(context, ToDoListDBContract.DB_NAME, null, ToDoListDBContract.DB_VERSION );
    }
     @Override
     public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ToDoListDBContract.Tasks.CREATE_TABLE);
     }

     @Override
     public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
         // the upgrade policy is simply discard the table and start over
           sqLiteDatabase.execSQL(ToDoListDBContract.Tasks.DELETE_TABLE);
         // create again the DB
          onCreate(sqLiteDatabase);

     }
 }


