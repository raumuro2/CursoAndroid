package com.example.cursoandroid.superheroapp

import android.icu.text.Transliterator.Position
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoandroid.TODOApp.Task
import com.example.cursoandroid.TODOApp.TasksViewHolder

class SuperheroAdapter (var superheroList:List<SuperHeroDataResponse> = emptyList()):
    RecyclerView.Adapter<SuperheroViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {

    }

    override fun getItemCount() = superheroList.size

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {

        holder.bind(superheroList[position])
    }

}