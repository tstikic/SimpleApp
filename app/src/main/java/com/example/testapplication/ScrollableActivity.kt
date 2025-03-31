package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import android.widget.Button

class ScrollableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrollable)

        val carousel: ViewPager2 = findViewById(R.id.carousel)

        val images = listOf(R.drawable.image1, R.drawable.image2, R.drawable.image3)

        val texts = listOf("Android Testing", "iOS testing", "Web browser testing")

        val adapter = ImageAdapter(images, texts)

        carousel.adapter = adapter

        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        TabLayoutMediator(tabLayout, carousel) { _, _ -> }.attach()

        // Start Learning Espresso Button
        val startLearningButton: Button = findViewById(R.id.start_learning_button)
        startLearningButton.setOnClickListener {
            val intent = Intent(this, RecyclerActivity::class.java)
            startActivity(intent)
        }
    }
}
