package com.example.testrecyclerview.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "musician_table")
data class Musician(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo
    val name: String,

    @ColumnInfo
    val lastName: String,

    @ColumnInfo
    val musicianId: Int,
)