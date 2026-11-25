package com.example.testapplication

import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding

/** Pads this view so its content clears the status bar instead of rendering under it. */
fun View.padForStatusBar() {
    val initialTop = paddingTop
    ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
        val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        v.updatePadding(top = initialTop + bars.top)
        insets
    }
}

/** Pads this view so its content clears the navigation bar instead of rendering under it. */
fun View.padForNavigationBar() {
    val initialBottom = paddingBottom
    ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
        val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        v.updatePadding(bottom = initialBottom + bars.bottom)
        insets
    }
}

/** Pads this view so its content clears both the status bar and the navigation bar. */
fun View.padForSystemBars() {
    val initialTop = paddingTop
    val initialBottom = paddingBottom
    ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
        val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        v.updatePadding(top = initialTop + bars.top, bottom = initialBottom + bars.bottom)
        insets
    }
}
