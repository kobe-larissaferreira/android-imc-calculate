package com.example.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var countHeight = 160
    var countWeight = 60

    fun onButtonCalculateClick(view: View){
        val height = countHeight.toString().toDouble()
        val weight = countWeight.toString().toInt()
        val intent = Intent(this@MainActivity, ResultActivity::class.java)

        intent.putExtra("EXTRA_HEIGHT", height)
        intent.putExtra("EXTRA_WEIGHT",weight )

        startActivity(intent)

        //button calcular
        val mButtonCalculate : Button = findViewById(R.id.buttonCalculate)
        mButtonCalculate.setOnClickListener { view ->
            onButtonCalculateClick(mButtonCalculate)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onTapAddHeight(view: View){
        countHeight++
       val textHeight = findViewById<TextView>(R.id.textHeight)
        textHeight.text = "$countHeight"
    }
    fun onTapDecreaseHeight(view: View){
        countHeight--
        val textHeight = findViewById<TextView>(R.id.textHeight)
        textHeight.text = "$countHeight"
    }
    fun onTapAddWeight(view: View){
        countWeight++
        val textWeight = findViewById<TextView>(R.id.textWeight)
        textWeight.text = "$countWeight"
    }
    fun onTapDecreaseWeight(view: View){
        countWeight--
        val textWeight = findViewById<TextView>(R.id.textWeight)
        textWeight.text = "$countWeight"
    }
}