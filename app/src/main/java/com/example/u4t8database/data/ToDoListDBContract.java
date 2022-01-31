package com.example.u4t8database.data;

public final class ToDoListDBContract {
  // Common fields to all DB

  // Database Name
  public static final String DB_NAME = "TODOLIST.DB";

  // Database Version
    public static final int DB_VERSION =  2;

    // To prevent someone from accidentally instantiating the contract class:
    // make the constructor private,
    private ToDoListDBContract(){

    }

    // schema

    // TABLE TASKS: Inner class that defines the table Tasks contents
    public static class Tasks{
        //   Table name
        public static final String TABLE_NAME = "TASKS";

        // Columns names
        public static final String _ID = "_id";
        public static final String TODO = "todo";
        public static final String TO_ACCOMPLISH = "to_accomplish";
        public static final String DESCRIPTION = "description";


        // CREATE_TABLE SQL String
        public static final String CREATE_TABLE = "CREATE TABLE " + Tasks.TABLE_NAME
                 + "("
                 + ToDoListDBContract.Tasks._ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                 + ToDoListDBContract.Tasks.TODO + "TEXT NOT NULL,"
                 + ToDoListDBContract.Tasks.TO_ACCOMPLISH + "TEXT, "
                 + ToDoListDBContract.Tasks.DESCRIPTION + "TEXT"
                 + ");";

    public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + Tasks.TABLE_NAME;

        // other table definition would come here
    }

    }


