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

class FormFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_form, container, false)

        val formFragText: TextView by lazy { view.findViewById(R.id.tvFragForm) }
        formFragText.text = "Tы на FormFragment"

        val gotoListButton: Button by lazy { view.findViewById(R.id.btFragForm) }
        gotoListButton.setOnClickListener {
            parentFragmentManager.commit {
                replace<ListFragment>(R.id.fragment_container_view)
            }
        }

        return view
    }
}