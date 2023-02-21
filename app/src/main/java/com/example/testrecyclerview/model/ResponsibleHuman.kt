package com.example.testrecyclerview.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "responsible_human_table")
data class ResponsibleHuman(

    @PrimaryKey(autoGenerate = true)
    val responsibleHumanId: Int,

    @ColumnInfo
    val name: String,

    @ColumnInfo(name = "last_name")
    val lastName: String,
) : Serializable