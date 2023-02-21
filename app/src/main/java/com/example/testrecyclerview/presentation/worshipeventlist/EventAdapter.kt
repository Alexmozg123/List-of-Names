package com.example.testrecyclerview.presentation.worshipeventlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testrecyclerview.R
import com.example.testrecyclerview.model.Event

class EventAdapter(
    private val items: List<Event>,
    private val deleteListener: (note: Event) -> Unit,
) : ListAdapter<Event, EventAdapter.NameHolder>(NameComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.holder_card, parent, false)
        return NameHolder(view)
    }

    override fun onBindViewHolder(nameHolder: NameHolder, position: Int) {
        nameHolder.bind(items[position], deleteListener)
    }

    class NameHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvTitle: TextView by lazy { itemView.findViewById(R.id.tvTitle) }
        private val tvDescription: TextView by lazy { itemView.findViewById(R.id.tvDescription) }
        private val ivDelete: ImageView by lazy { itemView.findViewById(R.id.ivTrash) }

        fun bind(item: Event, deleteListener: (note: Event) -> Unit) {
            tvTitle.text = item.eventName
//            tvDescription.text = item.dayOfEvent
            ivDelete.setOnClickListener {
                deleteListener(item)
            }
        }
    }

    class NameComparator : DiffUtil.ItemCallback<Event>() {

        // TODO: oldItem.id == newItem.id !!!
        override fun areItemsTheSame(oldItem: Event, newItem: Event) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Event, newItem: Event) =
            oldItem == newItem
    }
}