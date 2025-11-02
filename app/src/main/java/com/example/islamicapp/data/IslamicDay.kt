package com.example.islamicapp.data
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.islamicapp.R
data class IslamicDay(
    @DrawableRes val imageResourceId: Int,
    @StringRes val title: Int,
    val dayNumber: Int,
    @StringRes val description: Int
)

val islamicDays = listOf(
    IslamicDay(R.drawable.day1, R.string.day_title_1, 1, R.string.day_description_1),
    IslamicDay(R.drawable.day2, R.string.day_title_2, 2, R.string.day_description_2),
)
