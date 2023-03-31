package com.example.cursoandroid.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoandroid.databinding.ItemSuperheroBinding

class SuperheroViewHolder(view:View): RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)
    fun bind(superheroItemResponse: SuperHeroItemResponse){
        binding.tvSuperheroName.text = superheroItemResponse.name
    }
}