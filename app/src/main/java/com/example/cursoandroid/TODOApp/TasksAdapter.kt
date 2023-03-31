package com.example.cursoandroid.TODOApp

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoandroid.R

class TasksAdapter(var tasks:List<Task>, private val onTaskSeleceted: (Int) -> Unit):
    RecyclerView.Adapter<TasksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo_task, parent,false)
        return TasksViewHolder(view)
    }

    override fun getItemCount() = tasks.size


    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.render(tasks[position])
        holder.itemView.setOnClickListener{ onTaskSeleceted(position)}
    }

}