package com.example.testrecyclerview.presentation.namelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testrecyclerview.databinding.HolderCardBinding

class NameAdapter (
    private val items: MutableList<String>,
    private val listener: (name: String) -> Unit,
    ) : ListAdapter<String, NameAdapter.NameHolder>(NameComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameHolder {
        val binding = HolderCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return NameHolder(binding)
    }

    override fun onBindViewHolder(nameHolder: NameHolder, position: Int) {
        nameHolder.bind(items[position])
        nameHolder.itemView.setOnClickListener {
            listener(items[position])
        }
    }

    class NameHolder(private val binding: HolderCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(name: String) = with(binding) {
            titleTextView.text = name
        }
    }

    class NameComparator : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: String, newItem: String) =
            oldItem == newItem
    }
}