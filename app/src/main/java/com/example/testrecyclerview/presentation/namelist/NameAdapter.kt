package com.example.testrecyclerview.presentation.namelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testrecyclerview.R

class NameAdapter (
    items: List<String>,
    private val listener: (name: String) -> Unit
    ) : RecyclerView.Adapter<NameAdapter.NameHolder>() {

    private val listNames = items.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.holder_card, parent, false)
        return NameHolder(view)
    }

    override fun onBindViewHolder(nameHolder: NameHolder, position: Int) {
        nameHolder.nameTextView.text = listNames[position]
        nameHolder.itemView.setOnClickListener {
            listener(listNames[position])
        }
    }

    override fun getItemCount(): Int {
        return listNames.size
    }

    fun addItem(name: String) {
        listNames.add(name)
        notifyItemInserted(listNames.size - 1)
    }

    class NameHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.TitleTextView)
    }
}