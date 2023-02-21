package com.example.testrecyclerview.data.database.room.dao

import androidx.room.*
import com.example.testrecyclerview.data.database.room.relations.SongWithEvents
import com.example.testrecyclerview.model.Song

@Dao
interface SongDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSong(song: Song)

    // TODO: get realization this query later in filters
//    @Transaction
//    @Query("SELECT * FROM song_table WHERE songName = :song")
//    fun getEventsOfSong(song: Song): List<SongWithEvents>

    @Query("SELECT * FROM song_table")
    fun getAllSongs(): List<Song>

    @Update
    fun updateSong(song: Song)

    @Delete
    fun deleteSong(song: Song)

}