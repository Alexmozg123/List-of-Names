package com.example.testrecyclerview.testfragmentapp.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.testrecyclerview.R

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val listFragText: TextView by lazy { view.findViewById(R.id.tvFragList) }
        listFragText.text = "Tы на ListFragment"

        val gotoListButton: Button by lazy { view.findViewById(R.id.btFragList) }
        gotoListButton.setOnClickListener {
            parentFragmentManager.commit {
                replace<FormFragment>(R.id.fragment_container_view)
            }
        }

        return view
    }

}