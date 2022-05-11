package com.example.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.lang.Math.pow
import java.math.RoundingMode
import java.text.DecimalFormat

class ResultActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val intent = intent
        val height = intent.getDoubleExtra("EXTRA_HEIGHT", 0.00)
        val weight = intent.getIntExtra("EXTRA_WEIGHT", 0)
        val mTextViewInfo : TextView = findViewById(R.id.textViewInfoIMC)
        val mTextViewResult : TextView = findViewById(R.id.textResultIMC)

         fun doCalculateIMC(height: Double, weight: Int) : Double {

            val df = DecimalFormat("#.#")
            df.roundingMode = RoundingMode.CEILING

            var imc = weight/pow(height/100, 2.0)

            return df.format(imc).toDouble()
        }

        mTextViewResult.text = "" + doCalculateIMC(height, weight)


        fun resultInfo(imc: Double) : String{

            if(imc < 18.5  ){
                 return  "Peso abaixo do normal"
            }
            else if (imc in 18.5..24.9){
               return "Peso Normal"
            }
            else if(imc in 25.0..29.9){
                return "Sobrepeso"
            }
            else if(imc in 30.0..39.9){
               return "Obesidade Grau II"
            }
            return "Obesidade Grau III ou Mórbida"
        }
        mTextViewInfo.text = "" + resultInfo(doCalculateIMC(height,weight))
















        //button voltar
    val mButtonCalculateAgain : Button = findViewById(R.id.buttonCalculateAgain)
        mButtonCalculateAgain.setOnClickListener {
          val  intent2  =
              Intent(this@ResultActivity,MainActivity::class.java )
                startActivity(intent2)
        }


    }


    }
