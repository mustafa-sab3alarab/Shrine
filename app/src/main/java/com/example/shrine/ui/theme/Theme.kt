package com.example.shrine.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
        TypographyTest()
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

