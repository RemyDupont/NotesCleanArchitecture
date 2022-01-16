package com.remydupont.notescleanarchitecture.ui.feature_authentication.login

import androidx.compose.ui.focus.FocusState

sealed class LoginEvent {
    data class EnteredEmail(val value: String): LoginEvent()
    data class ChangeEmailFocus(val focusState: FocusState): LoginEvent()
    data class EnteredPassword(val value: String): LoginEvent()
    data class ChangePasswordFocus(val focusState: FocusState): LoginEvent()
    object Login: LoginEvent()
}
