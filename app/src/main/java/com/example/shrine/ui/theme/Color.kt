package com.example.shrine.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val ShrinePink900 = Color(0xFF442C2E)
val ShrinePink300 = Color(0xFFEAA4A4)
val ShrinePink200 = Color(0xFFF0CAC0)
val ShrinePink100 = Color(0xFFFEDBD0)
val ShrinePink50 = Color(0xFFFEEAE6)
val ShrinePink25 = Color(0xFFFFFBFA)
val ShrineRed700 = Color(0xFFB00020)
val ShrineScrim = Color(0xFF1A7D3636)
val ShrineGray200 = Color(0xFFE5E7EB)


internal val LightColorPalette = lightColors(
    primary = ShrinePink100,
    primaryVariant = ShrinePink200,
    onPrimary = ShrinePink900,
    onSecondary = ShrinePink900,
    secondary = ShrinePink100,
    surface = Color.White,
    onSurface = ShrinePink900,
    onBackground = ShrinePink900,
    background = ShrineGray200,
    onError = Color.White,
    error = ShrineRed700
)


internal val DarkColorPalette = darkColors(
    primary = ShrinePink100,
    primaryVariant = ShrinePink200,
    onPrimary = ShrinePink900,
    onSecondary = ShrinePink900,
    secondary = ShrinePink100,
    surface = Color.White,
    onSurface = ShrinePink900,
    onBackground = ShrinePink900,
    background = ShrineGray200,
    onError = Color.White,
    error = ShrineRed700
)