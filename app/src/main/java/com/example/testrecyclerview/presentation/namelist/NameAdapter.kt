package com.example.testrecyclerview.presentation.namelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testrecyclerview.R

class NameAdapter (
    private val items: MutableList<String>,
    private val listener: (name: String) -> Unit,
    ) : RecyclerView.Adapter<NameAdapter.NameHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.holder_card, parent, false)
        return NameHolder(view)
    }

    override fun onBindViewHolder(nameHolder: NameHolder, position: Int) {
        nameHolder.nameTextView.text = items[position]
        nameHolder.itemView.setOnClickListener {
            listener(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class NameHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.titleTextView)
    }
}