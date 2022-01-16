package com.remydupont.notescleanarchitecture.ui.feature_notes.notes

import com.remydupont.notescleanarchitecture.domain.model.Note
import com.remydupont.notescleanarchitecture.domain.util.notes.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSelection: NotesEvent()
}
