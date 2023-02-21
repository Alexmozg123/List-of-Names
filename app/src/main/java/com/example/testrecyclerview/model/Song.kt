package com.example.testrecyclerview.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "song_table")
data class Song(

    @PrimaryKey(autoGenerate = true)
    val songId: Int,

    @ColumnInfo(name = "song_name")
    val songName: String,
)

