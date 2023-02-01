package com.example.testrecyclerview.domain

import androidx.lifecycle.LiveData
import com.example.testrecyclerview.model.NoteModel

interface DataBaseRepository {

    fun readAll(): LiveData<List<NoteModel>>

    fun create(noteModel: NoteModel)

    fun update(noteModel: NoteModel)

    fun delete(noteModel: NoteModel)
}