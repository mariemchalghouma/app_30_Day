package com.example.islamicapp.ui.theme



import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

// Définition des formes (coins arrondis)
val Shapes = Shapes(
    // Petits coins arrondis (images)
    small = RoundedCornerShape(4.dp),

    // Coins arrondis moyens (cartes)
    medium = RoundedCornerShape(8.dp),

    // Grands coins arrondis (dialogs)
    large = RoundedCornerShape(16.dp),

    // Très petits coins arrondis
    extraSmall = RoundedCornerShape(2.dp),

    // Très grands coins arrondis
    extraLarge = RoundedCornerShape(24.dp)
)