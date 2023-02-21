package com.example.testrecyclerview.data.repository

import com.example.testrecyclerview.data.database.room.dao.EventDao
import com.example.testrecyclerview.data.database.room.dao.ResponsibleHumanDao
import com.example.testrecyclerview.domain.DataBaseRepository
import com.example.testrecyclerview.model.Event
import com.example.testrecyclerview.model.ResponsibleHuman

class RoomRepository(
    private val responsibleHumanDao: ResponsibleHumanDao,
    private val eventDao: EventDao,
) : DataBaseRepository {

    override fun createEvent(event: Event) {
        eventDao.insertEvent(event)
    }

    override fun createResponsibleHuman(responsibleHuman: ResponsibleHuman) {
        responsibleHumanDao.insertResponsibleHuman(responsibleHuman)
    }

    override fun deleteEvent(event: Event) {
        eventDao.deleteEvent(event)
    }

    override fun updateEvent(event: Event) {
        eventDao.updateEvent(event)
    }

    override fun deleteResponsibleHuman(responsibleHuman: ResponsibleHuman) {
        responsibleHumanDao.deleteResponsibleHuman(responsibleHuman)
    }

    override fun updateResponsibleHuman(responsibleHuman: ResponsibleHuman) {
        responsibleHumanDao.updateResponsibleHuman(responsibleHuman)
    }

}