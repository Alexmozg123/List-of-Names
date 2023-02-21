package com.example.testrecyclerview.data.database.room.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.testrecyclerview.model.Event
import com.example.testrecyclerview.model.ResponsibleHuman

data class ResponsibleHumanWithEvents(
    @Embedded val responsibleHuman: ResponsibleHuman,
    @Relation(
        parentColumn = "responsibleHumanId",
        entityColumn = "eventId"
    )
    val events: List<Event>,
)