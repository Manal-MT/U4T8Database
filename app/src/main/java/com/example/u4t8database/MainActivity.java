package com.example.u4t8database;

import android.content.Intent;
import android.os.Bundle;

import com.example.u4t8database.data.TodoListDBManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvTodoList;
    private TodoListDBManager todoListDBManager;
    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get instance to our DB Manager
        todoListDBManager = new TodoListDBManager(this);
        myAdapter = new MyAdapter(todoListDBManager);

        setUI();
    }

    private void setUI() {
        // ActionBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // set fab: opens and activity to ADD A NEW TASK to the DB
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener((view) -> {
            // start activity to add new record to our table
              startActivity(new Intent(getApplicationContext(),AddTaskActivity.class));
        });


    // set recyclerView
    rvTodoList = findViewById(R.id.rvTodoList);
    rvTodoList.setHasFixedSize(true);
    rvTodoList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL ));
    rvTodoList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    rvTodoList.setAdapter(myAdapter);
}

@Override
    public void onResume() {
        super.onResume();

        myAdapter.getData();
}

    @Override
    protected void onDestroy() {
        // close any connection to DB
        todoListDBManager.close();

        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}




