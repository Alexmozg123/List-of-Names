package com.example.testrecyclerview.data.database.room.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.testrecyclerview.model.Event
import com.example.testrecyclerview.model.EventSongCrossRef
import com.example.testrecyclerview.model.Song

data class EventWithSongs(
    @Embedded val event: Event,
    @Relation(
        parentColumn = "eventId",
        entityColumn = "songId",
        associateBy = Junction(EventSongCrossRef::class)
    )
    val songs: List<Song>
)