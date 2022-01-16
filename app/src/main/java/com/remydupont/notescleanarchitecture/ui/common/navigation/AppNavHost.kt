package com.remydupont.notescleanarchitecture.ui.common.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.remydupont.notescleanarchitecture.ui.feature_authentication.forgot_password.ForgotPasswordScreen
import com.remydupont.notescleanarchitecture.ui.feature_authentication.login.LoginScreen
import com.remydupont.notescleanarchitecture.ui.feature_authentication.register.RegisterScreen
import com.remydupont.notescleanarchitecture.ui.feature_counters.CountersScreen
import com.remydupont.notescleanarchitecture.ui.feature_notes.add_edit_note.AddEditNoteScreen
import com.remydupont.notescleanarchitecture.ui.feature_notes.notes.NotesScreen
import com.remydupont.notescleanarchitecture.ui.feature_profile.ProfileScreen

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
        // Auth screens
        loginScreenComposable(navController)
        registerScreenComposable(navController)
        forgotPasswordScreenComposable(navController)

        // Notes screens
        notesScreenComposable(navController)
        addEditNotesScreenComposable(navController)

        // Counters screen
        countersScreenComposable(navController)

        // Profile screen
        profileScreenComposable(navController)
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

/**
 * Wrap [LoginScreen] navigation composable
 */
private fun NavGraphBuilder.loginScreenComposable(navController: NavController) {
    apply {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen()
        }
    }
}

/**
 * Wrap [RegisterScreen] navigation composable
 */
private fun NavGraphBuilder.registerScreenComposable(navController: NavController) {
    apply {
        composable(route = Screen.RegisterScreen.route) {
            RegisterScreen()
        }
    }
}

/**
 * Wrap [ForgotPasswordScreen] navigation composable
 */
private fun NavGraphBuilder.forgotPasswordScreenComposable(navController: NavController) {
    apply {
        composable(route = Screen.ForgotPasswordScreen.route) {
            ForgotPasswordScreen()
        }
    }
}

/**
 * Wrap [CountersScreen] navigation composable
 */
private fun NavGraphBuilder.countersScreenComposable(navController: NavController) {
    apply {
        composable(route = Screen.CountersScreen.route) {
            CountersScreen()
        }
    }
}

/**
 * Wrap [ProfileScreen] navigation composable
 */
private fun NavGraphBuilder.profileScreenComposable(navController: NavController) {
    apply {
        composable(route = Screen.ProfileScreen.route) {
            ProfileScreen()
        }
    }
}
//endregion