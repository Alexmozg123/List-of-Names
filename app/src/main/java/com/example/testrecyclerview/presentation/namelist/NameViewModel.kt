package com.example.testrecyclerview.presentation.namelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testrecyclerview.domain.DataBaseRepository
import com.example.testrecyclerview.model.Instrument
import java.util.concurrent.Executors

class NameViewModel(
    private val repository: DataBaseRepository,
) : ViewModel() {

    private val executor = Executors.newSingleThreadExecutor()

    fun addNote(note: Instrument) {
        executor.submit { repository.create(note) }
    }

    fun deleteNote(note: Instrument) {
        executor.submit { repository.delete(note) }
    }

    fun getAllNotes(): LiveData<List<Instrument>> {
        return repository.readAll()
    }

    class NoteFactory(
        private val repository: DataBaseRepository,
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            NameViewModel(repository) as T
    }
}