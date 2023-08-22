package com.example.newapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var viewmodel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewmodel = ViewModelProvider(this).get(MyViewModel::class.java)

        var recycler = findViewById<RecyclerView>(R.id.productList)
        val layoutManager = LinearLayoutManager(this)
        recycler.layoutManager = layoutManager //recycler view layout setpup

        viewmodel.getData() // call get data method from view modal

// observing for live data changing
        viewmodel.response.observe(this) { result ->

//add adapter call here
            var adapter = MyAdapter(result)
            recycler.adapter = adapter
        }

        //observing for data


    }

}