package com.example.testrecyclerview.data.repository

import androidx.lifecycle.LiveData
import com.example.testrecyclerview.domain.DataBaseRepository
import com.example.testrecyclerview.data.database.room.dao.NoteDao
import com.example.testrecyclerview.model.NoteModel

class RoomRepository(private val noteDao: NoteDao) : DataBaseRepository {

    override fun readAll(): LiveData<List<NoteModel>> =
        noteDao.readAllNotes()

    override fun create(noteModel: NoteModel) {
        noteDao.insertNote(noteModel)
    }

    override fun update(noteModel: NoteModel) {
        noteDao.updateNote(noteModel)
    }

    override fun delete(noteModel: NoteModel) {
        noteDao.deleteNote(noteModel)
    }
}