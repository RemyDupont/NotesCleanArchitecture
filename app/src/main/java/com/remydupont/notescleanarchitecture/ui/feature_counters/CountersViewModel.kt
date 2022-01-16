package com.remydupont.notescleanarchitecture.ui.feature_counters

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.remydupont.notescleanarchitecture.domain.model.Counter
import com.remydupont.notescleanarchitecture.domain.use_case.counters.CounterUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountersViewModel @Inject constructor(
    private val counterUseCases: CounterUseCases
): ViewModel() {

    private val _uiState = mutableStateOf(CountersUiState())
    val uiState: State<CountersUiState> = _uiState

    private val _newCounterNameState = mutableStateOf("")
    val newCounterNameState: State<String> = _newCounterNameState

    private var getCountersJob: Job? = null

    init {
        getCounters()
    }

    fun onEvent(countersEvent: CountersEvent) {
        viewModelScope.launch {
            when (countersEvent) {
                is CountersEvent.SaveCounter -> {
                    counterUseCases.addCounterUseCase(
                        Counter(
                            name = newCounterNameState.value,
                            value = 0,
                            timestamp = System.currentTimeMillis()
                        )
                    )
                }
                is CountersEvent.DeleteCounter -> {
                    counterUseCases.deleteCounterUseCase(countersEvent.counter)
                }
                is CountersEvent.UpdateCounterName -> {
                    _newCounterNameState.value = countersEvent.newValue
                }
                CountersEvent.CancelNewCounter -> _newCounterNameState.value = ""
            }
        }
    }

    private fun getCounters() {
        getCountersJob?.cancel()
        getCountersJob = counterUseCases.getCountersUseCase()
            .onEach { counters ->
                if (counters.isNotEmpty() && uiState.value.isLoading) {
                    _uiState.value = uiState.value.copy(isLoading = false)
                }
                _uiState.value = uiState.value.copy(
                    counters = counters
                )
            }
            .launchIn(viewModelScope)
    }

}