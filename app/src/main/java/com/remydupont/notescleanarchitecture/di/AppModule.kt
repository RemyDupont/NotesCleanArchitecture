package com.remydupont.notescleanarchitecture.di

import android.app.Application
import androidx.room.Room
import com.remydupont.notescleanarchitecture.data.data_source.counters.CounterDatabase
import com.remydupont.notescleanarchitecture.data.data_source.notes.NoteDatabase
import com.remydupont.notescleanarchitecture.data.repository.CounterRepositoryImpl
import com.remydupont.notescleanarchitecture.data.repository.NoteRepositoryImpl
import com.remydupont.notescleanarchitecture.domain.repository.CounterRepository
import com.remydupont.notescleanarchitecture.domain.repository.NoteRepository
import com.remydupont.notescleanarchitecture.domain.use_case.counters.AddCounterUseCase
import com.remydupont.notescleanarchitecture.domain.use_case.counters.CounterUseCases
import com.remydupont.notescleanarchitecture.domain.use_case.counters.DeleteCounterUseCase
import com.remydupont.notescleanarchitecture.domain.use_case.counters.GetCountersUseCase
import com.remydupont.notescleanarchitecture.domain.use_case.notes.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository),
            addNoteUseCase = AddNoteUseCase(repository),
            getNoteUseCase = GetNoteUseCase(repository)
        )
    }


    @Provides
    @Singleton
    fun provideCounterDatabase(app: Application): CounterDatabase {
        return Room.databaseBuilder(
            app,
            CounterDatabase::class.java,
            CounterDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideCounterRepository(db: CounterDatabase): CounterRepository {
        return CounterRepositoryImpl(db.counterDao)
    }

    @Provides
    @Singleton
    fun provideCounterUseCases(repository: CounterRepository): CounterUseCases {
        return CounterUseCases(
            getCountersUseCase = GetCountersUseCase(repository),
            addCounterUseCase = AddCounterUseCase(repository),
            deleteCounterUseCase = DeleteCounterUseCase(repository)
        )
    }

}