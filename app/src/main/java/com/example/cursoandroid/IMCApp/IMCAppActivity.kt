package com.example.cursoandroid.IMCApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.cursoandroid.R
import com.example.cursoandroid.databinding.ActivityImcappBinding
import java.text.DecimalFormat

class IMCAppActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityImcappBinding
    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = true
    private var currentWeight:Int = 60
    private var currentHeight:Int = 120
    private var currentAge:Int = 20

    companion object{
        const val IMC_KEY = "IMC_RESULT"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcappBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewMale.setOnClickListener{ setGenderColor() }
        binding.viewFemale.setOnClickListener{ setGenderColor() }
        binding.rsHeight.addOnChangeListener{ _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            binding.tvHeight.text = "$currentHeight cm"
        }
        setWeight()
        binding.btnPlusWeight.setOnClickListener{
            currentWeight +=1
            setWeight()
        }
        binding.btnSubtractWeight.setOnClickListener{
            currentWeight -= 1
            setWeight()
        }

        binding.btnPlusAge.setOnClickListener{
            currentAge += 1
            setAge()
        }
        binding.btnSubtractAge.setOnClickListener{
            currentAge -= 1
            setAge()
        }
        binding.btnCalculate.setOnClickListener{
            val result = calculateIMC()
            navigateToResult(result)
        }
    }
    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }
    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble() /100 * currentHeight.toDouble()/100)
        return df.format(imc).toDouble()
    }

    private fun setAge() {
        binding.tvAge.text = currentAge.toString()
    }

    private fun setWeight() {
        binding.tvWeight.text = currentWeight.toString()
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        binding.viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        binding.viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {

        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }



}