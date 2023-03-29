package com.example.semesterproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.semesterproject.R
import com.example.semesterproject.model.Trader
import com.example.semesterproject.databinding.TraderCardViewBinding


class TraderAdapter(
    private val traders: List<Trader>,
    private val onItemClick: (adapterPosition: Int) -> Unit,
) :
    RecyclerView.Adapter<TraderAdapter.TraderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TraderViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TraderCardViewBinding.inflate(layoutInflater, parent, false)

        return TraderViewHolder(binding) { position ->
            onItemClick(position)
        }
    }

    override fun getItemCount() = traders.size

    override fun onBindViewHolder(holder: TraderViewHolder, position: Int) {
        val trader = traders[position]
        holder.bind(trader)
    }

    inner class TraderViewHolder(
        private val binding: TraderCardViewBinding,
        private val onItemClick: (adapterPosition: Int) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(trader: Trader) {
            Glide
                .with(binding.root)
                .load(trader.image)
                .error(R.drawable.baseline_10k_24)
                .into(binding.traderImage)

            binding.traderName.text = trader.name
            binding.traderCategory.text = trader.trader_category.toString()
        }
    }
}