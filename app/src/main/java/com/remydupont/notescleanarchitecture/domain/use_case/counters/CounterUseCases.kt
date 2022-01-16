package com.remydupont.notescleanarchitecture.domain.use_case.counters

data class CounterUseCases(
    val getCountersUseCase: GetCountersUseCase,
    val addCounterUseCase: AddCounterUseCase,
    val deleteCounterUseCase: DeleteCounterUseCase
)