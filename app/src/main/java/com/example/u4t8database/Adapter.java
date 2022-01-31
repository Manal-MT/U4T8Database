package com.example.u4t8database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.u4t8database.data.TodoListDBManager;
import com.example.u4t8database.model.Task;

import java.util.ArrayList;

 class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private TodoListDBManager todoListDBManager;
    private ArrayList<Task> myTaskList;

    // Class for each item
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvId;
        TextView tvTodo;
        TextView tvToAccomplish;
        TextView tvDescription;

        public MyViewHolder(View view){
            super(view);

            this.tvId =view.findViewById(R.id.tvId);
            this.tvTodo = view.findViewById(R.id.tvTodo);
            this.tvToAccomplish = view.findViewById(R.id.tvToAccomplish);
            this.tvDescription = view.findViewById(R.id.tvDescription);

        }

        // sets viewHolder views with data
        public void bind(Task task){
            this.tvId.setText(String.valueOf(task.get_id()));
            this.tvTodo.setText(task.getTodo());
            this.tvToAccomplish.setText(task.getToAccomplish());
            this.tvDescription.setText(task.getDescription());
        }
    }

    // constructor: todoListDBManager gets DB data
    public MyAdapter(TodoListDBManager todoListDBManager) {
        this.todoListDBManager = todoListDBManager;
    }

    // get data from DB
    public void getData() {
        this.myTaskList = todoListDBManager.getTasks();
        notifyDataSetChanged();
    }

    // Creates new view item: Layout Manager calls this method
    @NonNull
    @Override
    public  MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create item View:
        View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout, parent, false);

        return new MyViewHolder(itemLayout);

    }

    // replaces the data content od a viewholder (recycles old viewholder): Layout Manager calls this method
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
          // bind viewHolder with data at: position
         viewHolder.bind(myTaskList.get(position));
    }

    // returns the size of dataSet: Layout Manager calls this method
    @Override
    public int getItemCount() {
        return myTaskList.size();
    }
}
