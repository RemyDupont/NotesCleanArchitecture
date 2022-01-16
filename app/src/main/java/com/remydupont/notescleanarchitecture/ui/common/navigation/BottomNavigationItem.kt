package com.remydupont.notescleanarchitecture.ui.common.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.Note
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val route: String
) {
    object Notes: BottomNavItem("Notes", Icons.Default.Note, Screen.NotesScreen.route)
    object Counters: BottomNavItem("Counters", Icons.Default.AddCircleOutline, Screen.CountersScreen.route)
    object Profile: BottomNavItem("Profile", Icons.Default.Person, Screen.ProfileScreen.route)
}

val bottomNavItems = listOf(
    BottomNavItem.Notes,
    BottomNavItem.Counters,
    BottomNavItem.Profile
)

val bottomNavigationRoutes = listOf(
    Screen.NotesScreen.route,
    Screen.CountersScreen.route,
    Screen.ProfileScreen.route
)