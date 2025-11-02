package com.example.islamicapp.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Couleurs simples
private val LightColors = lightColorScheme(
    primary = Color(0xFF009688),      // Vert turquoise
    secondary = Color(0xFF4DB6AC),    // Vert clair
    tertiary = Color(0xFFFFD700),     // Or
    background = Color(0xFFFAFAFA),   // Blanc cassé
    surface = Color(0xFFFFFFFF)       // Blanc
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF4DB6AC),      // Vert clair
    secondary = Color(0xFF80CBC4),    // Vert très clair
    tertiary = Color(0xFFFFD54F),     // Or lumineux
    background = Color(0xFF121212),   // Noir
    surface = Color(0xFF1E1E1E)       // Gris foncé
)

@Composable
fun IslamicAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colors.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}