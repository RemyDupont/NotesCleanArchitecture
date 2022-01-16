package com.remydupont.notescleanarchitecture.ui.feature_notes.notes

import com.remydupont.notescleanarchitecture.domain.model.Note
import com.remydupont.notescleanarchitecture.domain.util.notes.NoteOrder
import com.remydupont.notescleanarchitecture.domain.util.notes.OrderType

data class NotesUiState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSelectionVisible: Boolean = false
)
