package com.remydupont.notescleanarchitecture.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Counter(
    val name: String,
    val value: Int,
    val timestamp: Long,
    @PrimaryKey val id: Int? = null
)