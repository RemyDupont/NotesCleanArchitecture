package com.remydupont.notescleanarchitecture.ui.feature_counters

import com.remydupont.notescleanarchitecture.domain.model.Counter

sealed class CountersEvent {
    data class UpdateCounterName(val newValue: String): CountersEvent()
    object CancelNewCounter: CountersEvent()
    object SaveCounter : CountersEvent()
    data class DeleteCounter(val counter: Counter): CountersEvent()
}