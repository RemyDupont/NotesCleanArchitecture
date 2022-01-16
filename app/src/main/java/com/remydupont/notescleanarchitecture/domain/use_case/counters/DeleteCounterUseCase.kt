package com.remydupont.notescleanarchitecture.domain.use_case.counters

import com.remydupont.notescleanarchitecture.domain.model.Counter
import com.remydupont.notescleanarchitecture.domain.repository.CounterRepository

class DeleteCounterUseCase(
    private val repository: CounterRepository
) {

    suspend operator fun invoke(counter: Counter) {
        repository.deleteCounter(counter)
    }
}