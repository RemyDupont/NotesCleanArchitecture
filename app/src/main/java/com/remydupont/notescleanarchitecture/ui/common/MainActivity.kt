package com.remydupont.notescleanarchitecture.ui.common

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.*
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.remydupont.notescleanarchitecture.ui.common.navigation.AppBottomNavigation
import com.remydupont.notescleanarchitecture.ui.common.navigation.AppNavHost
import com.remydupont.notescleanarchitecture.ui.common.navigation.bottomNavigationRoutes
import com.remydupont.notescleanarchitecture.ui.theme.NotesCleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading.value
            }
        }

        setContent {
            NotesCleanArchitectureTheme {
                val scaffoldState = rememberScaffoldState()
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                Scaffold(
                    bottomBar = {
                        AnimatedVisibility(
                            visible = bottomNavigationRoutes.contains(currentRoute),
                            enter = fadeIn() + expandVertically(),
                            exit = fadeOut() + shrinkVertically()
                        ) {
                            AppBottomNavigation(navController = navController)
                        }
                    },
                    scaffoldState = scaffoldState
                ) { innerPadding ->
                    AppNavHost(
                        navController = navController,
                        scaffoldState = scaffoldState,
                        Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}