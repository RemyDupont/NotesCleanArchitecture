package com.remydupont.notescleanarchitecture.ui.feature_authentication.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.remydupont.notescleanarchitecture.domain.util.login.LoginFieldValidator
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    private val _emailState = mutableStateOf("")
    val emailState: State<String> = _emailState

    private val _passwordState = mutableStateOf("")
    val passwordState: State<String> = _passwordState

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()


    fun onEvent(event: LoginEvent) {
        when(event) {
            is LoginEvent.EnteredEmail -> { _emailState.value = event.value }
            is LoginEvent.EnteredPassword -> { _passwordState.value = event.value }
            is LoginEvent.ChangeEmailFocus -> { }
            is LoginEvent.ChangePasswordFocus -> { }
            LoginEvent.Login -> { loginUser() }
        }
    }


    private fun loginUser() {
        viewModelScope.launch {
            val isEmailValid = LoginFieldValidator.isEmailValid(emailState.value)
            val isPasswordValid = LoginFieldValidator.isPasswordValid(passwordState.value)
            val uiEvent = if (isEmailValid && isPasswordValid) {
                UiEvent.LoginSucceed
            } else {
                UiEvent.LoginFailed
            }
            _eventFlow.emit(uiEvent)
        }
    }

    sealed class UiEvent {
        object LoginSucceed: UiEvent()
        object LoginFailed: UiEvent()
    }

}