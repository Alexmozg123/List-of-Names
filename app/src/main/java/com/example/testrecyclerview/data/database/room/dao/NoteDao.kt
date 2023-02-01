package com.example.testrecyclerview.data.database.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.testrecyclerview.model.NoteModel

@Dao
interface NoteDao {

    @Query("SELECT * FROM note_table")
    fun readAllNotes(): LiveData<List<NoteModel>>

    @Insert
    fun insertNote(noteModel: NoteModel)

    @Update
    fun updateNote(noteModel: NoteModel)

    @Delete
    fun deleteNote(noteModel: NoteModel)
}