package com.example.testrecyclerview.presentation.namelist

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.testrecyclerview.R
import com.example.testrecyclerview.presentation.form.FormActivity

class NameListActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recyclerView)
    }

    private val addItemButton: Button by lazy {
        findViewById(R.id.addItemButton)
    }

    private val viewModel = NameViewModel()

    private val getName = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            it.data?.getStringExtra(FormActivity.EXTRA_NAME)?.let { name ->
                viewModel.addName(name)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addItemButton.setOnClickListener {
            getName.launch(FormActivity.createIntent(this))
        }

        viewModel.result.observe(this) {
            when (it) {
                is NameViewResult.ListNames -> setNameAdapter(it.listOfNames)
            }
        }
    }

    private fun setNameAdapter(names: MutableList<String>) {
        val adapter =
            NameAdapter(names) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        recyclerView.adapter = adapter
    }
}