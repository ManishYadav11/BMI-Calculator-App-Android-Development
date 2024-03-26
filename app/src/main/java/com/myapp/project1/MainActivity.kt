package com.myapp.project1

import android.content.Intent
import android.graphics.Color
import android.media.Rating
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView
//    private lateinit var rating : Rating
//    private lateinit var rating : Rating

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        weightEditText = findViewById(R.id.weightEditText)
        heightEditText = findViewById(R.id.heightEditText)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.textViewResult)
        calculateButton.setOnClickListener {
            calculateBMI()
            secondActivity()
        }
    }

    private fun secondActivity() {
        val intent = Intent(this , MainActivity2 ::class.java)
        intent.putExtra("We" , weightEditText.text.toString())
        intent.putExtra("He" , heightEditText.text.toString())
        intent.putExtra("Bmi" ,   resultTextView.text.toString())
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.header_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
            return when (item.itemId) {
                R.id.login -> {
                    // Handle login menu item click
                    openLoginActivity()
                    true
                }

                R.id.rating ->{
                    ratingActivity()
                    true
                }
            // Add handling for menu items here
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun openLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun ratingActivity(){
        val intent = Intent(this , RatingBar ::class.java)
        startActivity(intent)
    }


    private fun calculateBMI() {
        val weight: Double = weightEditText.text.toString().toDouble()
        val height: Double = heightEditText.text.toString().toDouble()

        val bmi = calculateBMIValue(weight, height)
        displayBMIResult(bmi)

    }

    private fun calculateBMIValue(weight: Double, height: Double): Double {
        // Formula to calculate BMI: weight (kg) / (height (m) * height (m))
        return weight / ((height / 100) * (height / 100))
    }

    private fun displayBMIResult(bmi: Double) {
        val message: String
        val color: Int

        if (bmi < 18.5) {
            message = "Underweight"
            color = Color.RED
        } else if (bmi < 25) {
            message = "Normal weight"
            color = Color.GREEN
        } else if (bmi < 30) {
            message = "Overweight"
            color = Color.YELLOW
        } else {
            message = "Obese"
            color = Color.RED
        }

//        fun secondActivity(){
//            val intent = Intent(this , MainActivity2 ::class.java)
//            intent.putExtra("height" , weightEditText.text.toString())
//            intent.putExtra("weight" , heightEditText.text.toString())
//
//            intent.putExtra("Bmi" ,   resultTextView.text.toString())
//            startActivity(intent)
//        }

        resultTextView.text = "Your BMI: $bmi ($message)"
        resultTextView.setTextColor(color)

//        weightEditText.text.clear()
//        heightEditText.text.clear()


    }
}
