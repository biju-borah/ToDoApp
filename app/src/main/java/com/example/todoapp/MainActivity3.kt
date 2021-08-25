package com.example.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity3 : AppCompatActivity() {
    var adapter: MyRecyclerViewAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val todo = intent.getSerializableExtra("todo") as ArrayList<String>?

        // set up the RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.tv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyRecyclerViewAdapter(this, todo!!)
        recyclerView.adapter = adapter
    }
}