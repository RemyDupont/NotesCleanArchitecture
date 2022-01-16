package com.remydupont.notescleanarchitecture.data.repository

import com.remydupont.notescleanarchitecture.data.data_source.counters.CounterDao
import com.remydupont.notescleanarchitecture.domain.model.Counter
import com.remydupont.notescleanarchitecture.domain.repository.CounterRepository
import kotlinx.coroutines.flow.Flow

class CounterRepositoryImpl(
    private val dao: CounterDao
): CounterRepository {

    override fun getCounters(): Flow<List<Counter>> {
        return dao.getCounters()
    }

    override suspend fun getCounterById(id: Int): Counter? {
        return dao.getCounterById(id)
    }

    override suspend fun insertCounter(counter: Counter) {
        dao.insertCounter(counter)
    }

    override suspend fun deleteCounter(counter: Counter) {
        return dao.deleteCounter(counter)
    }

}