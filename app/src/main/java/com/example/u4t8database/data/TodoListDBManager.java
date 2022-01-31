package com.example.u4t8database.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.u4t8database.data.ToDoListDBContract;
import com.example.u4t8database.data.TodoListDBHelper;
import com.example.u4t8database.model.Task;

import java.util.ArrayList;

public class TodoListDBManager {
    private TodoListDBHelper todoListDBHelper;


    public TodoListDBManager(Context context) {
        todoListDBHelper = TodoListDBHelper.getInstance(context);

    }




    // Operations
    // Create new row
    public void insert(String todo, String when, String description) {
        // open database to read and write
        SQLiteDatabase sqLiteDatabase = todoListDBHelper.getWritableDatabase();

        if (sqLiteDatabase != null) {
            ContentValues contentValue = new ContentValues();

            contentValue.put(ToDoListDBContract.Tasks.TODO, todo);
            contentValue.put(ToDoListDBContract.Tasks.TO_ACCOMPLISH, when);
            contentValue.put(ToDoListDBContract.Tasks.DESCRIPTION, description);

            sqLiteDatabase.insert(ToDoListDBContract.Tasks.TABLE_NAME, null, contentValue);


        }
    }

    // Get all data from table
    public ArrayList<Task> getTasks() {
         ArrayList<Task>  taskList = new ArrayList<>();



        // open database to read
        SQLiteDatabase sqLiteDatabase = todoListDBHelper.getReadableDatabase();

        if (sqLiteDatabase != null) {
            String[] projection = new String[]{ToDoListDBContract.Tasks._ID,
                    ToDoListDBContract.Tasks.TODO,
                    ToDoListDBContract.Tasks.TO_ACCOMPLISH,
                    ToDoListDBContract.Tasks.DESCRIPTION};

            Cursor cursorTodoList = sqLiteDatabase.query(ToDoListDBContract.Tasks.TABLE_NAME,
                    projection,                      // The columns toView return
                    null,                    // no Where clause
                    null,                  // no values for the WHERE clause
                    null,                       // don't group the rows
                    null,                        // don't filter by row groups
                    null);                     // don't sort rows

            if (cursorTodoList != null) {
                // get the column indexes for required columns
                int _idIndex = cursorTodoList.getColumnIndexOrThrow(ToDoListDBContract.Tasks._ID);
                int todoIndex = cursorTodoList.getColumnIndexOrThrow(ToDoListDBContract.Tasks.TODO);
                int to_AccomplishIndex = cursorTodoList.getColumnIndexOrThrow(ToDoListDBContract.Tasks.TO_ACCOMPLISH);
                int descriptionIndex = cursorTodoList.getColumnIndexOrThrow(ToDoListDBContract.Tasks.DESCRIPTION);


                // read data and add to Arraylist
                while (cursorTodoList.moveToNext()) {
                    Task task = new Task(
                            cursorTodoList.getInt(_idIndex),
                            cursorTodoList.getString(todoIndex),
                            cursorTodoList.getString(to_AccomplishIndex),
                            cursorTodoList.getString(descriptionIndex));


                    taskList.add(task);

                }

                //clone cursor to free resources
                cursorTodoList.close();

            }
        }
        return taskList;
    }
    public void close(){
      todoListDBHelper.close();
    }
}


