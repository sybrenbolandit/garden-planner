package nl.sybrenbolandit.gardenplanner.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import nl.sybrenbolandit.gardenplanner.databinding.ListItemActionBinding
import nl.sybrenbolandit.gardenplanner.domain.Action
import java.util.*

class ActionAdapter(val clickListener: ActionListener) : ListAdapter<Action, ActionAdapter.ViewHolder>(ActionDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(clickListener, item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ListItemActionBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: ActionListener, item: Action) {
            binding.action = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemActionBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

class ActionDiffCallback: DiffUtil.ItemCallback<Action>() {
    override fun areItemsTheSame(oldItem: Action, newItem: Action): Boolean {
        return oldItem.code == newItem.code
    }

    override fun areContentsTheSame(oldItem: Action, newItem: Action): Boolean {
        return oldItem == newItem
    }
}

class ActionListener(val clickListener: (code: UUID) -> Unit) {
    fun onClick(action: Action) = clickListener(action.code)
}