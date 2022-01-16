package com.remydupont.notescleanarchitecture.data.data_source.counters

import androidx.room.Database
import androidx.room.RoomDatabase
import com.remydupont.notescleanarchitecture.domain.model.Counter

@Database(
    entities = [Counter::class],
    version = 1
)
abstract class CounterDatabase: RoomDatabase() {

    abstract val counterDao: CounterDao

    companion object {
        const val DATABASE_NAME = "counter_db"
    }

}