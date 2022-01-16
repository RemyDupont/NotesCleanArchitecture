package com.remydupont.notescleanarchitecture.domain.use_case.counters

import com.remydupont.notescleanarchitecture.domain.model.Counter
import com.remydupont.notescleanarchitecture.domain.repository.CounterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCountersUseCase(
    private val repository: CounterRepository
) {

    operator fun invoke(): Flow<List<Counter>> {
        return repository.getCounters().map { counters ->
            counters.sortedByDescending { it.timestamp }
        }
    }
}