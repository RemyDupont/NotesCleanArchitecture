package com.remydupont.notescleanarchitecture.domain.use_case.notes

import com.remydupont.notescleanarchitecture.domain.model.Note
import com.remydupont.notescleanarchitecture.domain.repository.NoteRepository
import com.remydupont.notescleanarchitecture.domain.util.notes.NoteOrder
import com.remydupont.notescleanarchitecture.domain.util.notes.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(
    private val repository: NoteRepository
) {

    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>> {
        return repository.getNotes().map { notes ->
            when(noteOrder.orderType) {
                OrderType.Ascending -> {
                    when(noteOrder){
                        is NoteOrder.Color -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Title -> notes.sortedBy { it.color }
                    }
                }
                OrderType.Descending -> {
                    when(noteOrder){
                        is NoteOrder.Color -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Title -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}