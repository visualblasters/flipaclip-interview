package com.flipaclip.interview.presentation.brushes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.flipaclip.interview.data.Brush
import com.flipaclip.interview.databinding.BrushesRowBinding

class BrushAdapter(private val onBrushClick: (Brush) -> Unit) : ListAdapter<Brush, BrushAdapter.BrushViewHolder>(BrushDiffCallback()) {
    var selectedBrush: String = ""

    class BrushViewHolder(private val binding: BrushesRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(brush: Brush) {
            binding.BrushNameTV.text = brush.name
            binding.brushValueTV.text = brush.strokeSize.toString()
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrushViewHolder {
        val binding = BrushesRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BrushViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BrushViewHolder, position: Int) {
        val brush = getItem(position)
        holder.bind(brush)
        holder.itemView.isSelected = brush.id == selectedBrush
        holder.itemView.setOnClickListener {
            onBrushClick(brush)
        }
    }

    class BrushDiffCallback : DiffUtil.ItemCallback<Brush>() {
        override fun areItemsTheSame(oldItem: Brush, newItem: Brush): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Brush, newItem: Brush): Boolean {
            return oldItem == newItem
        }
    }
}