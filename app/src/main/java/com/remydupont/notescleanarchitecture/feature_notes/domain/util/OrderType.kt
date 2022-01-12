package com.remydupont.notescleanarchitecture.feature_notes.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
