package com.example.testapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class RecyclerActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.setLayoutManager(LinearLayoutManager(this))

        // Sample data
        val items: List<String> = mutableListOf("Dan", "Andrei", "Eran", "Tijana", "Dorian", "Luciano", "Silvia", "Leandro")
        itemAdapter = ItemAdapter(items)
        recyclerView.setAdapter(itemAdapter)
    }
}
