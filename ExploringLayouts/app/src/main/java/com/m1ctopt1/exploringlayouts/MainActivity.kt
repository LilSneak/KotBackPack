package com.m1ctopt1.exploringlayouts

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            setContentView(R.layout.main_menu)
    }
    fun loadConstraintLayout(v: View) {
        setContentView(R.layout.activity_main)
    }
    fun loadTableLayout(v: View) {
        setContentView(R.layout.my_table_layout)
    }
    fun loadMenuLayout(v: View) {
        setContentView(R.layout.main_menu)
    }
}