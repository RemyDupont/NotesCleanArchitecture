package com.remydupont.notescleanarchitecture.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColors(
    primary = DarkGray,
    onPrimary = Color.White,
    background = Color.White,
    onBackground = DarkGray,
    surface = Color.White,
    onSurface = DarkGray,

    /*
    primaryVariant = Color(0xFF3700B3),
    secondary = Color(0xFF03DAC6),
    secondaryVariant = Color(0xFF018786),
    error = Color(0xFFB00020),
    onSecondary = Color.Black,
    onError = Color.White
    */
)

private val DarkColorPalette = darkColors(
    primary = Color.White,
    onPrimary = DarkGray,
    background = DarkGray,
    onBackground = Color.White,
    surface = LightGray,
    onSurface = Color.White
)

@Composable
fun NotesCleanArchitectureTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}