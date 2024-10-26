package com.m1ctopt1.exploringlayouts

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            setContentView(R.layout.main_menu)

            setSupportActionBar(findViewById(R.id.my_toolbar))
    }
    fun loadConstraintLayout(v: View) {
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))
    }
    fun loadTableLayout(v: View) {
        setContentView(R.layout.my_table_layout)
        setSupportActionBar(findViewById(R.id.my_toolbar))
    }
    fun loadMenuLayout(v: View) {
        setContentView(R.layout.main_menu)
        setSupportActionBar(findViewById(R.id.my_toolbar))
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_settings -> {
                val intent = Intent (this, ActivitySettings::class.java)

                startActivity(intent)
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }

        }
    }
    
}