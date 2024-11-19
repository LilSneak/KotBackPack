package com.m1ctopt1.recipeapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)


          findViewById<Button>(R.id.btnGetStarted).setOnClickListener{
              var intent = Intent(this@SplashActivity, HomeActivity::class.java)
              startActivity(intent)
              finish()
          }
        }
    }
