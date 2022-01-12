package com.remydupont.notescleanarchitecture.feature_notes.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.remydupont.notescleanarchitecture.ui.theme.*
import java.lang.Exception

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(
            RedOrange,
            RedPink,
            LightGreen,
            BabyBlue,
            Violet
        )
    }
}

class InvalidNoteException(message: String): Exception(message)
