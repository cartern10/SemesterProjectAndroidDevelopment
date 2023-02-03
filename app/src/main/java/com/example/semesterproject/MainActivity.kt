package com.example.semesterproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.trader_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val traders = mutableListOf<Trader>()

        for(i in 0..30) {
            traders.add(createTraders())
        }

        val adapter = TraderAdapter(traders)
        recyclerView.adapter = adapter

    }

    private fun createTraders() = Trader(
        name = "Liam",
        id = 1,
        image = R.drawable.baseline_10k_24,
        trader_category = "Loot",
        quest = "Do Stuff",
        map = "Customs",
        loyalty = 5

    )

}