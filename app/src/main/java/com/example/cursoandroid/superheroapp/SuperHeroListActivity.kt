package com.example.cursoandroid.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import com.example.cursoandroid.R
import com.example.cursoandroid.databinding.ActivityMainBinding
import com.example.cursoandroid.databinding.ActivitySuperHeroListBinding
import okhttp3.Dispatcher
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class SuperHeroListActivity : AppCompatActivity() {
    private lateinit var  binding: ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean { return false}

        })

        }
    private fun searchByName(query: String){
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<SuperHeroDataResponse> = retrofit.create(ApiService::class.java).getSuperheroes(query)
            if(myResponse.isSuccessful){
                val response = myResponse.body()
                if(response != null){
                    runOnUiThread{
                        binding.progressBar.isVisible = false
                    }
                }
            }else{

            }
        }
    }
    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}