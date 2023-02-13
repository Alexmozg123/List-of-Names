package com.example.testrecyclerview.presentation.namelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testrecyclerview.R
import com.example.testrecyclerview.model.NoteModel

class NameAdapter(
    private val items: List<NoteModel>,
    private val deleteListener: (note: NoteModel) -> Unit,
) : ListAdapter<NoteModel, NameAdapter.NameHolder>(NameComparator()) {

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

        fun bind(item: NoteModel, deleteListener: (note: NoteModel) -> Unit) {
            tvTitle.text = item.title
            tvDescription.text = item.description
            ivDelete.setOnClickListener {
                deleteListener(item)
            }
        }
    }

    class NameComparator : DiffUtil.ItemCallback<NoteModel>() {
        override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel) =
            oldItem == newItem
    }
}