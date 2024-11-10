package com.m1ctopt1.todolist

import Task
import ToDoList
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var listViewTasks : ListView
    lateinit var tasks: List<Task>
    lateinit var toDoList: ToDoList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        supportActionBar?.setTitle("ToDoList")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        tasks = ArrayList<Task>(0)
        toDoList = ToDoList(this)
        listViewTasks = findViewById<ListView>(R.id.listViewTasks)

        populateListViewTasks()

        listViewTasks.setOnItemClickListener(listViewListener)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if(id == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    fun handleClick(v: View){
        if(v.id == R.id.buttonAddToDo){
            val addTask = Intent(this, EditTaskActivity::class.java)
            startActivity(addTask)
        }
    }
    fun populateListViewTasks(){
        var tasksStrings: ArrayList<String>



    }
}