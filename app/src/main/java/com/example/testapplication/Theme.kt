package com.example.testapplication

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

private val AppColorScheme = lightColorScheme(
    primary = Color(0xFF2A6F9E),
    onPrimary = Color.White,
    secondary = Color(0xFF0E7490),
    onSecondary = Color.White,
    tertiary = Color(0xFFFF6B47),
    onTertiary = Color.White,
    background = Color(0xFFF4F6F9),
    onBackground = Color(0xFF1B1F24),
    surface = Color.White,
    onSurface = Color(0xFF1B1F24),
    surfaceVariant = Color(0xFFEEF1F5),
    onSurfaceVariant = Color(0xFF5B6472),
)

/** Same dark navy wash used behind every XML screen, for a cohesive look. */
val AppBackgroundGradient = Brush.verticalGradient(
    listOf(Color(0xFF2A6F9E), Color(0xFF0B3B5C))
)

/** Text/tint for content sitting directly on [AppBackgroundGradient] (mirrors colors.xml). */
val OnDarkPrimary = Color.White
val OnDarkSecondary = Color(0xFFC7D4E0)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AppColorScheme,
        content = content
    )
}
