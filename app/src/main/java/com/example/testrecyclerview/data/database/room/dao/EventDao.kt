package com.example.testrecyclerview.data.database.room.dao

import androidx.room.*
import com.example.testrecyclerview.data.database.room.relations.EventWithSongs
import com.example.testrecyclerview.model.Event

@Dao
interface EventDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEvent(event: Event)

    // TODO: don't forget add parameter data in signature
//    @Transaction
//    @Query("SELECT * FROM event_table WHERE eventName := event")
//    fun getSongsOfEvent(event: Event): List<EventWithSongs>

    @Query("SELECT * FROM event_table")
    fun getAllEvents(): List<Event>

    @Update
    fun updateEvent(event: Event)

    @Delete
    fun deleteEvent(event: Event)

}