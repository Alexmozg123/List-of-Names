package com.example.testrecyclerview.presentation.namelist

sealed class NameViewResult {
    data class ListNames(val listOfNames: MutableList<String>) : NameViewResult()
}