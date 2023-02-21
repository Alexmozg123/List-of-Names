package com.example.testrecyclerview.presentation.worshipeventlist

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.testrecyclerview.R
import com.example.testrecyclerview.data.database.room.WorshipDatabase
import com.example.testrecyclerview.data.repository.RoomRepository
import com.example.testrecyclerview.domain.DataBaseRepository
import com.example.testrecyclerview.model.Event
import com.example.testrecyclerview.presentation.form.FormActivity

class NameListActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recyclerView) }
    private val addItemButton: Button by lazy { findViewById(R.id.addItemButton) }

    private lateinit var viewModel: NameViewModel

    private val getName = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK) {
            it.data?.getSerializableExtra(FormActivity.NOTE_ARRAY)?.let { note ->
//                note as Event
//                if (note.eventName == "" && note.dayOfEvent == "") {
//                    Log.e("EMPTY_DATA", "You didn't put any data")
//                } else { viewModel.addNote(note) }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addItemButton.setOnClickListener {
            getName.launch(FormActivity.createIntent(this))
        }

//        viewModel = ViewModelProvider(
//            this,
//            NameViewModel.NoteFactory(createRepository())
//        )[NameViewModel::class.java]
//
//        viewModel.getAllNotes().observe(this) { result ->
//            setNameAdapter(result)
//        }
    }

//    private fun createRepository(): DataBaseRepository {
//        val dataBase = WorshipDatabase.getInstance(this)
//        return RoomRepository(dataBase.getNoteDao())
//    }

//    private fun setNameAdapter(notes: List<Event>) {
//        val adapter =
//            EventAdapter(notes) {
//                viewModel.deleteNote(it)
//            }
//        adapter.submitList(notes)
//        recyclerView.adapter = adapter
//    }
}