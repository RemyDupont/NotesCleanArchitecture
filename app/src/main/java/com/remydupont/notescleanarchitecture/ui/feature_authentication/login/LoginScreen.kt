package com.remydupont.notescleanarchitecture.ui.feature_authentication.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.navOptions
import com.remydupont.notescleanarchitecture.ui.common.navigation.Screen
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LoginScreen(
    navController: NavController,
    scaffoldState: ScaffoldState,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val passwordVisibility = remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when(event) {
                LoginViewModel.UiEvent.LoginSucceed -> { navigateToHomeScreen(navController) }
                LoginViewModel.UiEvent.LoginFailed -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = "Email or password incorrect"
                    )
                }
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val email = viewModel.emailState.value
            val password = viewModel.passwordState.value

            TextField(
                value = email,
                label = { Text("Email") },
                placeholder = { Text("Email") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions {
                    focusManager.moveFocus(FocusDirection.Down)
                },
                onValueChange = {
                    viewModel.onEvent(LoginEvent.EnteredEmail(it))
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = password,
                label = { Text("Password") },
                placeholder = { Text("Password") },
                visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    viewModel.onEvent(LoginEvent.Login)
                }),
                onValueChange = {
                    viewModel.onEvent(LoginEvent.EnteredPassword(it))
                },
                trailingIcon = {
                    val image = if (passwordVisibility.value) Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff
                    IconButton(onClick = {
                        passwordVisibility.value = !passwordVisibility.value
                    }) {
                        Icon(imageVector  = image, "Toggle visibility")
                    }
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                viewModel.onEvent(LoginEvent.Login)
            }) {
                Text(text = "Login", fontSize = 18.sp)
            }
        }
    }
}

private fun navigateToHomeScreen(navController: NavController) {
    navController.navigate(
        route = Screen.NotesScreen.route,
        navOptions {
            popUpTo(Screen.LoginScreen.route) {
                inclusive = true
            }
        }
    )
}