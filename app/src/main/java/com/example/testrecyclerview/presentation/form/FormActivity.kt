package com.example.testrecyclerview.presentation.form

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.testrecyclerview.R
import com.example.testrecyclerview.model.NoteModel

class FormActivity : AppCompatActivity() {

    private val title: EditText by lazy { findViewById(R.id.editTextTitle) }
    private val description: EditText by lazy { findViewById(R.id.editTextDesc) }
    private val saveButton: Button by lazy { findViewById(R.id.saveButton) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        saveButton.setOnClickListener {
            sendResult()
        }
    }

    private fun sendResult() {
        val title = title.text.toString()
        val description = description.text.toString()
        setResult(RESULT_OK, Intent()
            .putExtra(NOTE_ARRAY, NoteModel(title = title, description = description)))
        finish()
    }

    companion object {
        const val NOTE_ARRAY: String = "noteArray"
        fun createIntent(context: Context): Intent = Intent(context, FormActivity::class.java)
    }
}