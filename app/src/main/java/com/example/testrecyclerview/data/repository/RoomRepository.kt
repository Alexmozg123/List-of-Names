package com.example.testrecyclerview.data.repository

import androidx.lifecycle.LiveData
import com.example.testrecyclerview.domain.DataBaseRepository
import com.example.testrecyclerview.data.database.room.dao.NoteDao
import com.example.testrecyclerview.model.Instrument

class RoomRepository(private val noteDao: NoteDao) : DataBaseRepository {

    override fun readAll(): LiveData<List<Instrument>> =
        noteDao.readAllNotes()

    override fun create(noteModel: Instrument) {
        noteDao.insertNote(noteModel)
    }

    override fun update(noteModel: Instrument) {
        noteDao.updateNote(noteModel)
    }

    override fun delete(noteModel: Instrument) {
        noteDao.deleteNote(noteModel)
    }
}