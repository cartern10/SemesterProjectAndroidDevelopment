package com.example.semesterproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.semesterproject.R
import com.example.semesterproject.databinding.FragmentPokemonDetailBinding
import com.example.semesterproject.viewmodel.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetailFragment : Fragment() {

    private var _binding: FragmentPokemonDetailBinding? = null
    private val binding get() = _binding!!

    private val pokemonViewModel: PokemonViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)

        if(arguments != null){
            val pokemon = pokemonViewModel.fetchById(requireArguments().getInt(BUNDLE_ID))

            Glide.with(requireContext()).load(pokemon.image).into(binding.pokemonImage)
            binding.pokemonName.text = getString(R.string.name, pokemon.name)
        }
        return binding.root
    }

    //static
    companion object{
        private const val BUNDLE_ID = "id"

        //This can be changed
        fun newInstance(id: Int): PokemonDetailFragment {
            val detailFragment = PokemonDetailFragment()
            detailFragment.arguments = bundleOf(BUNDLE_ID to id)
            return detailFragment
        }
    }
}