package com.remydupont.notescleanarchitecture.domain.repository

import com.remydupont.notescleanarchitecture.domain.model.Counter
import kotlinx.coroutines.flow.Flow

interface CounterRepository {

    fun getCounters(): Flow<List<Counter>>

    suspend fun getCounterById(id: Int): Counter?

    suspend fun insertCounter(counter: Counter)

    suspend fun deleteCounter(counter: Counter)

}