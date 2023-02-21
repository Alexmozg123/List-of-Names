package com.example.testrecyclerview.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "event_table")
data class Event(

    @PrimaryKey(autoGenerate = true)
    val eventId: Int,

    @ColumnInfo
    val eventName: String,
) : Serializable