package com.example.shrine.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ShrineTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val ShrineColors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = ShrineColors,
        typography = ShrineTypography,
        shapes = ShrineShapes,
        content = content
    )
}

@Preview(name = "Theme Test", showSystemUi = true, showBackground = true)
@Composable
private fun ThemeTest() {
    ShrineTheme {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Button(onClick = { }) {
                Text(text = "This is a button".uppercase())
            }
        }

    }
}


@Preview(name = "Typography Test", showSystemUi = true, showBackground = true)
@Composable
private fun TypographyTest() {
    Column {
        Text(
            text = "H1 , Rubik",
            style = MaterialTheme.typography.h1
        )
        Text(
            text = "H2 , Rubik",
            style = MaterialTheme.typography.h2
        )
        Text(
            text = "H3 , Rubik",
            style = MaterialTheme.typography.h3
        )
        Text(
            text = "Body 1 , Rubik",
            style = MaterialTheme.typography.body1
        )
        Text(
            text = "Button , Rubik",
            style = MaterialTheme.typography.button
        )
    }
}

