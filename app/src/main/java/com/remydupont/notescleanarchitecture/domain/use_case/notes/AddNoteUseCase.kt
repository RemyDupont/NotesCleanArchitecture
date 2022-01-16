package com.remydupont.notescleanarchitecture.domain.use_case.notes

import com.remydupont.notescleanarchitecture.domain.model.InvalidNoteException
import com.remydupont.notescleanarchitecture.domain.model.Note
import com.remydupont.notescleanarchitecture.domain.repository.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("Title cannot be empty")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("Content cannot be empty")
        }
        repository.insertNote(note)
    }
}