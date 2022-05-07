package com.gbnsolutions.loginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class HomeScreen : AppCompatActivity() {
    lateinit var itemlist: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        itemlist = findViewById(R.id.itemlist)

    }
}