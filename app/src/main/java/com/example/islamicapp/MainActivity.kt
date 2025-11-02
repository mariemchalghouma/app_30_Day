
package com.example.islamicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.islamicapp.data.IslamicDay
import com.example.islamicapp.data.islamicDays
import com.example.islamicapp.ui.theme.IslamicAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IslamicAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    IslamicApp()
                }
            }
        }
    }
}

@Composable
fun IslamicApp() {
    Scaffold(

    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            items(islamicDays) { day ->
                IslamicDayItem(
                    islamicDay = day,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
fun IslamicDayItem(
    islamicDay: IslamicDay,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Card(modifier = modifier.clickable { expanded = !expanded }) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_small)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IslamicDayIcon(islamicDay.imageResourceId)
                IslamicDayInformation(islamicDay.title, islamicDay.dayNumber)
                Spacer(Modifier.weight(1f))
                IslamicDayItemButton(expanded = expanded)
            }
            AnimatedVisibility(
                visible = expanded,
                enter = expandVertically(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                ) + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                IslamicDayDescription(
                    islamicDay.description,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}

@Composable
private fun IslamicDayItemButton(
    expanded: Boolean,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = { /* Handled by Card click */ },
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun IslamicDayIcon(
    @DrawableRes islamicDayIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(islamicDayIcon),
        contentDescription = null
    )
}

@Composable
fun IslamicDayInformation(
    @StringRes islamicDayTitle: Int,
    islamicDayNumber: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(islamicDayTitle),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = "Jour : $islamicDayNumber",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun IslamicDayDescription(
    @StringRes islamicDayDescription: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(islamicDayDescription),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}



