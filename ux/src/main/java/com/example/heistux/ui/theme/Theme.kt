package com.example.heistux.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = com.example.heist_cx_drd.ui.theme.Black,
    primaryVariant = com.example.heist_cx_drd.ui.theme.Blackish,
    secondary = com.example.heist_cx_drd.ui.theme.White
)

private val LightColorPalette = lightColors(
    primary = com.example.heist_cx_drd.ui.theme.Black,
    primaryVariant = com.example.heist_cx_drd.ui.theme.Blackish,
    secondary = com.example.heist_cx_drd.ui.theme.White

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun HeistUXTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}