package com.remydupont.notescleanarchitecture.data.data_source.counters

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.remydupont.notescleanarchitecture.domain.model.Counter
import kotlinx.coroutines.flow.Flow

@Dao
interface CounterDao {

    @Query("SELECT * FROM counter")
    fun getCounters(): Flow<List<Counter>>

    @Query("SELECT * FROM counter WHERE id = :id")
    suspend fun getCounterById(id: Int): Counter?

    @Insert(onConflict = REPLACE)
    suspend fun insertCounter(counter: Counter)

    @Delete
    suspend fun deleteCounter(counter: Counter)

}