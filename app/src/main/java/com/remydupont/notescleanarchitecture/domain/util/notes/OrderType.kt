package com.remydupont.notescleanarchitecture.domain.util.notes

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
