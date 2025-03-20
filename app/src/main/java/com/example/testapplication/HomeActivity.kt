package com.example.testapplication
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class HomeActivity : AppCompatActivity() {
    private var welcomeTextView: TextView? = null
    private var imageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        // Initialize UI components
        welcomeTextView = findViewById<TextView>(R.id.welcome_text)
        imageView = findViewById<ImageView>(R.id.image)
        val goToRecyclerViewButton = findViewById<Button>(R.id.go_to_recycler_view_button)

        goToRecyclerViewButton.setOnClickListener {
            val intent = Intent(this@HomeActivity, RecyclerActivity::class.java)
            startActivity(intent)
        }

    }
}
