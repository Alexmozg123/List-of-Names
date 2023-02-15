package com.example.testrecyclerview.domain

import androidx.lifecycle.LiveData
import com.example.testrecyclerview.model.Instrument

interface DataBaseRepository {

    fun readAll(): LiveData<List<Instrument>>

    fun create(noteModel: Instrument)

    fun update(noteModel: Instrument)

    fun delete(noteModel: Instrument)
}