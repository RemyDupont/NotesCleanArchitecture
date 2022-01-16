package com.remydupont.notescleanarchitecture.ui.common.navigation

sealed class Screen(
    val route: String
) {
    object NotesScreen: Screen("notes_screen")
    object AddEditNoteScreen: Screen("add_edit_notes_screen")
}