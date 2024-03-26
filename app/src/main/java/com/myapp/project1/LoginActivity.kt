package com.myapp.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.myapp.project1.R.*

private lateinit var btn : Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_login)

    }
}