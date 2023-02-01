package com.example.testrecyclerview.presentation.namelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testrecyclerview.R
import com.example.testrecyclerview.model.NoteModel

class NameAdapter(
    private val items: List<NoteModel>,
    private val listener: (name: String) -> Unit,
) : ListAdapter<NoteModel, NameAdapter.NameHolder>(NameComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameHolder {
        val view: View
        val inflater = LayoutInflater.from(parent.context)
        view = if (viewType == VT_1) {
            inflater.inflate(R.layout.holder_card, parent, false)
        } else {
            inflater.inflate(R.layout.holder_card2, parent, false)
        }
        return NameHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return if ((items[position].id ?: 0) % 2 == 1) VT_1 else VT_2
    }

    override fun onBindViewHolder(nameHolder: NameHolder, position: Int) {
        nameHolder.bind(items[position])
        nameHolder.itemView.setOnClickListener {
            listener(items[position].title)
        }
    }

    class NameHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvTitle: TextView by lazy {
            itemView.findViewById(R.id.tvTitle)
        }
        private val tvId: TextView by lazy {
            itemView.findViewById(R.id.tvId)
        }

        fun bind(item: NoteModel) {
            tvTitle.text = item.title
            tvId.text = item.id.toString()
        }
    }

    class NameComparator : DiffUtil.ItemCallback<NoteModel>() {
        override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel) =
            oldItem == newItem
    }

    companion object {
        private const val VT_1 = 1
        private const val VT_2 = 2
    }
}