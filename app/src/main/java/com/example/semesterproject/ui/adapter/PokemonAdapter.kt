package com.example.semesterproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.semesterproject.R
import com.example.semesterproject.model.Pokemon
import com.example.semesterproject.databinding.PokemonCardViewBinding


class PokemonAdapter(
    private val pokemons: List<Pokemon>,
    private val onItemClick: (adapterPosition: Int) -> Unit,
) :
    RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PokemonCardViewBinding.inflate(layoutInflater, parent, false)

        return PokemonViewHolder(binding) { position ->
            onItemClick(position)
        }
    }

    override fun getItemCount() = pokemons.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.bind(pokemon)
    }

    inner class PokemonViewHolder(
        private val binding: PokemonCardViewBinding,
        private val onItemClick: (adapterPosition: Int) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(pokemon: Pokemon) {
            Glide
                .with(binding.root)
                .load(pokemon.image)
                .error(R.drawable.baseline_10k_24)
                .into(binding.pokemonImage)

            binding.pokemonName.text = pokemon.name //fix this
            binding.pokemonCategory.text = pokemon.pokemon_category.toString() //fix this
        }
    }
}