package com.remydupont.notescleanarchitecture.domain.use_case.notes

import com.remydupont.notescleanarchitecture.domain.model.Note
import com.remydupont.notescleanarchitecture.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}