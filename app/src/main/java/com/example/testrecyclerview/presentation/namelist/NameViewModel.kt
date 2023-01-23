package com.example.testrecyclerview.presentation.namelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.LinkedList

class NameViewModel : ViewModel() {

    private val _result = MutableLiveData<NameViewResult>()
    val result: LiveData<NameViewResult>
        get() = _result

    private var names: MutableList<String> = LinkedList<String>()

    fun addName(name: String) {
        names.add(name)
        updateNamesList()
    }

    private fun updateNamesList() {
        _result.value = NameViewResult.ListNames(names)
    }
}