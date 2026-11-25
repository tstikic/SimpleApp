package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class WorkshopWelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workshop_welcome)

        // Pad the root (not the scroll content) so scrollTo() never parks a view under the nav bar
        findViewById<View>(R.id.workshop_welcome_root).padForSystemBars()

        val carousel: ViewPager2 = findViewById(R.id.workshop_carousel)

        val cards = listOf(
            WorkshopCard(R.drawable.ic_workshop_book, R.string.workshop_card_1_title, R.string.workshop_card_1_description),
            WorkshopCard(R.drawable.ic_workshop_practice, R.string.workshop_card_2_title, R.string.workshop_card_2_description),
            WorkshopCard(R.drawable.ic_workshop_progress, R.string.workshop_card_3_title, R.string.workshop_card_3_description)
        )

        carousel.adapter = WorkshopCardAdapter(cards)

        val dots = listOf<View>(
            findViewById(R.id.workshop_dot_1),
            findViewById(R.id.workshop_dot_2),
            findViewById(R.id.workshop_dot_3)
        )
        carousel.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                dots.forEachIndexed { index, dot ->
                    dot.setBackgroundResource(
                        if (index == position) R.drawable.workshop_dot_selected else R.drawable.workshop_dot_unselected
                    )
                }
            }
        })

        // Get Started Button (below the fold, requires scrolling)
        val getStartedButton: Button = findViewById(R.id.get_started_button)
        getStartedButton.setOnClickListener {
            startActivity(Intent(this, WorkshopSuccessActivity::class.java))
        }
    }
}
