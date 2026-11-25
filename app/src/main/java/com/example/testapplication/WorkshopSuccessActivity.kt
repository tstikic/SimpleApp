package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WorkshopSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workshop_success)

        findViewById<View>(R.id.workshop_success_root).padForSystemBars()

        val goToRecyclerViewButton = findViewById<Button>(R.id.workshop_recycler_button)
        goToRecyclerViewButton.setOnClickListener {
            startActivity(Intent(this, RecyclerActivity::class.java))
        }
    }
}
