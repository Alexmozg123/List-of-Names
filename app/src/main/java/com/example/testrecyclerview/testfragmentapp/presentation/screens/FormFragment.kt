package com.example.testrecyclerview.testfragmentapp.presentation.screens

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.testrecyclerview.R

class FormFragment : Fragment(R.layout.fragment_form) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.tvTestFormFrag)?.let {
            it.text = "Start this"
        }
    }

}