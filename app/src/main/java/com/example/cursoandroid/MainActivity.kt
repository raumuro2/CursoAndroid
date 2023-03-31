package com.example.cursoandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cursoandroid.IMCApp.IMCAppActivity
import com.example.cursoandroid.TODOApp.TodoActivity
import com.example.cursoandroid.databinding.ActivityMainBinding
import com.example.cursoandroid.superheroapp.SuperHeroListActivity

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIMCApp.setOnClickListener{ navigateToImcApp()}
        binding.btnTODO.setOnClickListener{ navigateToTODOApp()}
        binding.btnSuperhero.setOnClickListener{ navigateToSuperHeroApp()}
    }

    private fun navigateToSuperHeroApp() {
        val intent = Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToImcApp(){
        val intent = Intent(this, IMCAppActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToTODOApp(){
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }
}