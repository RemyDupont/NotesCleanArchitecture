package com.remydupont.notescleanarchitecture.data.repository.notes

import com.remydupont.notescleanarchitecture.data.data_source.notes.NoteDao
import com.remydupont.notescleanarchitecture.domain.model.Note
import com.remydupont.notescleanarchitecture.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
): NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }

}