package com.example.testrecyclerview.presentation.form

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.testrecyclerview.R

class FormActivity : AppCompatActivity() {

    private val saveButton: Button by lazy {
        findViewById(R.id.saveButton)
    }

    private val editName: EditText by lazy {
        findViewById(R.id.editTextTextPersonName)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        saveButton.setOnClickListener {
            val name = editName.text.toString()
            setResult(Activity.RESULT_OK, Intent().putExtra(EXTRA_NAME, name))
            finish()
        }
    }

    companion object {
        const val EXTRA_NAME: String = "extraName"
        fun createIntent(context: Context): Intent = Intent(context, FormActivity::class.java)
    }
}