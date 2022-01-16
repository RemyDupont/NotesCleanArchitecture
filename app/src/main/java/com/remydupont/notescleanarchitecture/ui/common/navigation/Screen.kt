package com.remydupont.notescleanarchitecture.ui.common.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.remydupont.notescleanarchitecture.ui.feature_notes.notes.NotesScreen

sealed class Screen(
    val route: String
) {
    object NotesScreen: Screen("notes_screen")
    object AddEditNoteScreen: Screen("add_edit_notes_screen")
}