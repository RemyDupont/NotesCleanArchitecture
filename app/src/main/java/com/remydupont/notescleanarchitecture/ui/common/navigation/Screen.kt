package com.remydupont.notescleanarchitecture.ui.common.navigation

sealed class Screen(
    val route: String
) {

    // Authentication screens
    object LoginScreen: Screen("login_screen")
    object RegisterScreen: Screen("register_screen")
    object ForgotPasswordScreen: Screen("forgot_password_screen")

    // Home screen
    object HomeScreen: Screen("home_screen")

    // Notes screens
    object NotesScreen: Screen("notes_screen")
    object AddEditNoteScreen: Screen("add_edit_notes_screen")

    // Counters screens
    object CounterScreen: Screen("counters_screen")

    // Profile screen
    object ProfileScreen: Screen("profile_screen")

}