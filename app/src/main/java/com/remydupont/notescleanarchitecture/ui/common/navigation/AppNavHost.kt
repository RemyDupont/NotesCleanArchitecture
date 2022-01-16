package com.remydupont.notescleanarchitecture.ui.common.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.remydupont.notescleanarchitecture.ui.feature_notes.add_edit_note.AddEditNoteScreen
import com.remydupont.notescleanarchitecture.ui.feature_notes.notes.NotesScreen

/**
 * Define application [NavHost]
 */
@ExperimentalAnimationApi
@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.NotesScreen.route
    ) {
        notesScreenComposable(navController)
        addEditNotesScreenComposable(navController)
    }
}



//region NavGraphBuilder Composable
/**
 * Wrap [NotesScreen] navigation composable
 */
@ExperimentalAnimationApi
private fun NavGraphBuilder.notesScreenComposable(navController: NavController) {
    apply {
        composable(route = Screen.NotesScreen.route) {
            NotesScreen(navController = navController)
        }
    }
}

/**
 * Wrap [AddEditNoteScreen] navigation composable
 */
private fun NavGraphBuilder.addEditNotesScreenComposable(navController: NavController) {
    apply {
        composable(
            route = Screen.AddEditNoteScreen.route +
                    "?noteId={noteId}&noteColor={noteColor}",
            arguments = listOf(
                navArgument(name = "noteId") {
                    type = NavType.IntType
                    defaultValue = -1
                },
                navArgument(name = "noteColor") {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) {
            val color = it.arguments?.getInt("noteColor") ?: -1
            AddEditNoteScreen(
                navController = navController,
                noteColor = color
            )
        }
    }
}
//endregion