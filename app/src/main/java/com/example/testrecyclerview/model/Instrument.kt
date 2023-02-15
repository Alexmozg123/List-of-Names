package com.example.testrecyclerview.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "instrument_table")
data class Instrument(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo
    var title: String,

    @ColumnInfo
    var description: String,
) : Serializable