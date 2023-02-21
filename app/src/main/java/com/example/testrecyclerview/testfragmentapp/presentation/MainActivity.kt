package com.example.testrecyclerview.testfragmentapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.testrecyclerview.R
import com.example.testrecyclerview.testfragmentapp.presentation.screens.ListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_single_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                addToBackStack(null)
                add<ListFragment>(R.id.fragment_container_view)
            }
        }
    }
}