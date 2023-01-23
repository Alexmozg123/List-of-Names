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

    private lateinit var adapter: NameAdapter

    private val getName = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            it.data?.getStringExtra(FormActivity.EXTRA_NAME)?.let { name ->
                adapter.addItem(name)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter =
            NameAdapter(listOf("Саша", "Ника", "Наташа", "Катя", "Святик", "Сережка")) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        recyclerView.adapter = adapter

        addItemButton.setOnClickListener {
            getName.launch(FormActivity.createIntent(this))
        }
    }
}