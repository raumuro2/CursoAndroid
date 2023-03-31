package com.example.cursoandroid.superheroapp

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoandroid.R
import com.example.cursoandroid.TODOApp.Task
import com.example.cursoandroid.TODOApp.TasksViewHolder

class SuperheroAdapter (var superheroList:List<SuperHeroItemResponse> = emptyList()):
    RecyclerView.Adapter<SuperheroViewHolder>()  {

    fun updateList(superheroList:List<SuperHeroItemResponse>){
        this.superheroList = superheroList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        return SuperheroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        )
    }

    override fun getItemCount() = superheroList.size

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {

        holder.bind(superheroList[position])
    }

}