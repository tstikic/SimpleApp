package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import android.widget.Button

class ScrollableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrollable)

        findViewById<View>(R.id.app_header).padForStatusBar()
        findViewById<View>(R.id.scrollable_root).padForNavigationBar()

        val carousel: ViewPager2 = findViewById(R.id.carousel)

        val images = listOf(R.drawable.image1, R.drawable.image2, R.drawable.image3)

        val texts = listOf("Android Testing", "iOS testing", "Web browser testing")

        val adapter = ImageAdapter(images, texts)

        carousel.adapter = adapter

        val dots = listOf<View>(
            findViewById(R.id.dot_1),
            findViewById(R.id.dot_2),
            findViewById(R.id.dot_3)
        )
        carousel.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                dots.forEachIndexed { index, dot ->
                    dot.setBackgroundResource(
                        if (index == position) R.drawable.dot_selected else R.drawable.dot_unselected
                    )
                }
            }
        })

        // Start Learning Espresso Button
        val startLearningButton: Button = findViewById(R.id.start_learning_button)
        startLearningButton.setOnClickListener {
            val intent = Intent(this, WorkshopJoinActivity::class.java)
            startActivity(intent)
        }
    }
}
