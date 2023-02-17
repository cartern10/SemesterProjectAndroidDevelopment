package com.example.semesterproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.semesterproject.ui.TraderDetailFragment

class TraderAdapter(private val traders: List<Trader>) :
    RecyclerView.Adapter<TraderAdapter.TraderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TraderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.trader_card_view, parent, false)
        return TraderViewHolder(view){position ->
            val trader = traders[position]

            val bundle = bundleOf(
                "image" to trader.image,
                "name" to trader.name,
                "category" to trader.trader_category,
                "location" to trader.location,
                "rep" to trader.level_max_rep,
                "info" to trader.info
            )

            val detailFragment = TraderDetailFragment()
            detailFragment.arguments = bundle

            val activity = view.context as AppCompatActivity

            activity.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, detailFragment)
                addToBackStack(null)
            }
        }
    }

    override fun getItemCount() = traders.size

    override fun onBindViewHolder(holder: TraderViewHolder, position: Int) {
        val trader = traders[position]
        Glide
            .with(holder.itemView.context)
            .load(trader.image)
            .into(holder.traderImage);

        holder.traderName.text = trader.name
        holder.traderCategory.text = trader.trader_category
        holder.traderLocation.text = trader.location
    }

    inner class TraderViewHolder(
        itemView: View,
        private val OnItemClick: (adapterPosition: Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        val traderImage: ImageView = itemView.findViewById(R.id.trader_image)
        val traderName: TextView = itemView.findViewById(R.id.trader_name)
        val traderCategory: TextView = itemView.findViewById(R.id.trader_category)
        val traderLocation: TextView = itemView.findViewById(R.id.trader_location)

        init {
            itemView.setOnClickListener {
                OnItemClick(adapterPosition)
            }
        }
    }
}