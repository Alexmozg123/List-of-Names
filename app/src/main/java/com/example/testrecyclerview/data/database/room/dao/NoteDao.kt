package com.example.testrecyclerview.data.database.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.testrecyclerview.model.Instrument

@Dao
interface NoteDao {

    @Query("SELECT * FROM instrument_table")
    fun readAllNotes(): LiveData<List<Instrument>>

    @Insert
    fun insertNote(noteModel: Instrument)

    @Update
    fun updateNote(noteModel: Instrument)

    @Delete
    fun deleteNote(noteModel: Instrument)
}