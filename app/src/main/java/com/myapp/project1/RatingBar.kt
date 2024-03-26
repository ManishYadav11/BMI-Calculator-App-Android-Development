package com.myapp.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.RatingBar

class RatingBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating_bar)

        val btn : Button = findViewById(R.id.submitBtn)
        val rating1 : RatingBar = findViewById(R.id.ratingBar2)
        val rateT : TextView = findViewById(R.id.averageText)

        btn.setOnClickListener {
            val r1 = rating1.rating
            when (r1.toInt()) {
                5 -> {
                    rateT.text = "best"
                }

                4 -> {
                    rateT.text = "good"
                }

                3 -> {
                    rateT.
                    text = "average"
                }

                2 -> {
                    rateT.text = "bad"
                }

                else ->
                    rateT.text = "worst"
            }

            
        }

    }
}