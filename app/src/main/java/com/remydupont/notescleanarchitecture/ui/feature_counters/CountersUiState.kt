package com.remydupont.notescleanarchitecture.ui.feature_counters

import com.remydupont.notescleanarchitecture.domain.model.Counter

data class CountersUiState(
    val counters: List<Counter> = emptyList(),
    val isLoading: Boolean = true,
    val isAddCounterDialogVisible: Boolean = false,
)
