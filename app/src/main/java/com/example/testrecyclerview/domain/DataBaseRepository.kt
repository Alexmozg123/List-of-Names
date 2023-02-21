package com.example.testrecyclerview.domain

import com.example.testrecyclerview.model.Event
import com.example.testrecyclerview.model.ResponsibleHuman

interface DataBaseRepository {

    fun createResponsibleHuman(responsibleHuman: ResponsibleHuman)

    fun deleteResponsibleHuman(responsibleHuman: ResponsibleHuman)

    fun updateResponsibleHuman(responsibleHuman: ResponsibleHuman)

    fun createEvent(event: Event)

    fun deleteEvent(event: Event)

    fun updateEvent(event: Event)

}