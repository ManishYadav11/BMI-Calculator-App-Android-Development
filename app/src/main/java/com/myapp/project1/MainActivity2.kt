package com.myapp.project1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val heigth : TextView =findViewById(R.id.text1)
        val weight : TextView = findViewById(R.id.text2)
        val result : TextView = findViewById(R.id.res)

        val h  = intent.getStringExtra("He").toString()
        val w  = intent.getStringExtra("We").toString()
        val bmi = intent.getStringExtra("Bmi").toString()

        heigth.text = "Your height is : $h"
        weight.text = "Your weight is : $w"
        result.text = "Your BMI is : $bmi"
    }
}