package com.remydupont.notescleanarchitecture.domain.use_case.notes

import com.remydupont.notescleanarchitecture.domain.model.Note
import com.remydupont.notescleanarchitecture.domain.repository.NoteRepository

class GetNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}