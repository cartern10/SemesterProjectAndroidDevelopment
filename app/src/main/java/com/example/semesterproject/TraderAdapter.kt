package com.example.semesterproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TraderAdapter(private val traders: List<Trader>) : RecyclerView.Adapter<TraderAdapter.TraderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TraderViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.trader_card_view, parent, false)
    )

    override fun getItemCount() = traders.size

    override fun onBindViewHolder(holder: TraderViewHolder, position: Int) {
        val trader = traders[position]
        holder.traderImage.setImageResource(trader.image)
        holder.traderName.text = trader.name
        holder.traderCategory.text = trader.trader_category
        holder.traderLocation.text = trader.location
        holder.traderLoyalty.text = trader.loyalty.toString()
    }

    class TraderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val traderImage: ImageView = itemView.findViewById(R.id.trader_image)
        val traderName: TextView = itemView.findViewById(R.id.trader_name)
        val traderCategory: TextView = itemView.findViewById(R.id.trader_category)
        val traderLocation: TextView = itemView.findViewById(R.id.trader_location)
        val traderLoyalty: TextView = itemView.findViewById(R.id.trader_loyalty)
    }
}