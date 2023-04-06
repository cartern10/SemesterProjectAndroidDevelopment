package com.example.semesterproject.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.semesterproject.R
import com.example.semesterproject.databinding.TowerCardViewBinding
import com.example.semesterproject.model.Tower


class TowerAdapter(
    private val onItemClick: (tower: Tower, adapterPosition: Int) -> Unit,
) : RecyclerView.Adapter<TowerAdapter.TowerViewHolder>() {

    init {
        setHasStableIds(true)
    }

    private val towers = mutableListOf<Tower>()

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(towerList: List<Tower>) {
        towers.clear()
        towers.addAll(towerList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TowerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TowerCardViewBinding.inflate(layoutInflater, parent, false)
        return TowerViewHolder(binding) { position ->
            onItemClick(towers[position], position)
        }
    }

    override fun getItemCount() = towers.size

    override fun getItemId(position: Int) = position.toLong()

    override fun onBindViewHolder(holder: TowerViewHolder, position: Int) {
        val tower = towers[position]
        holder.bind(tower)
    }

    inner class TowerViewHolder(
        private val binding: TowerCardViewBinding,
        private val onItemClick: (adapterPosition: Int) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(tower: Tower) {
            //Glide
            //    .with(binding.root)
            //    .load(tower.image)
            //    .error(R.drawable.baseline_10k_24)
            //    .into(binding.TowerImage)

            binding.towerName.text = tower.name

        }
    }
}
