package com.remydupont.notescleanarchitecture.domain.util.login

object LoginFieldValidator {

    fun isEmailValid(email: String): Boolean {
        return email.isNotEmpty() &&
                email.isNotBlank() &&
                email.contains("@")
    }

    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty() &&
                password.isNotBlank() &&
                password.length >= 8
    }

}