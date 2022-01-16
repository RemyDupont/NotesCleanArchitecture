package com.remydupont.notescleanarchitecture.domain.use_case.notes

import com.remydupont.notescleanarchitecture.domain.use_case.notes.AddNoteUseCase
import com.remydupont.notescleanarchitecture.domain.use_case.notes.DeleteNoteUseCase
import com.remydupont.notescleanarchitecture.domain.use_case.notes.GetNoteUseCase
import com.remydupont.notescleanarchitecture.domain.use_case.notes.GetNotesUseCase

data class NoteUseCases(
    val getNotesUseCase: GetNotesUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
    val addNoteUseCase: AddNoteUseCase,
    val getNoteUseCase: GetNoteUseCase
)