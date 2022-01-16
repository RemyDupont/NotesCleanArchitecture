package com.remydupont.notescleanarchitecture.ui.feature_profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.navOptions
import com.remydupont.notescleanarchitecture.ui.common.navigation.Screen

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Profile Screen", fontSize = 32.sp)
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    navigateToLogin(navController)
                }
            ) {
                Text(text = "Logout", fontSize = 18.sp)
            }
        }
    }
}

private fun navigateToLogin(navController: NavController) {
    navController.navigate(
        route = Screen.LoginScreen.route,
        navOptions {
            popUpTo(Screen.NotesScreen.route) {
                inclusive = true
            }
        }
    )
}