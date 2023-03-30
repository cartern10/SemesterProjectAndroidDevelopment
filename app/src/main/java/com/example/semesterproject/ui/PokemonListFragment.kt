package com.example.semesterproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.semesterproject.R
import com.example.semesterproject.databinding.FragmentPokemonListBinding
import com.example.semesterproject.ui.adapter.PokemonAdapter
import com.example.semesterproject.viewmodel.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonListFragment : Fragment() {

    private var _binding: FragmentPokemonListBinding? = null
    private val binding get() = _binding!!

    private val characterViewModel: PokemonViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentPokemonListBinding.inflate(inflater, container, false)

        binding.pokemonRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val characters = characterViewModel.fillData()

        val adapter = PokemonAdapter(characters) { position ->
            requireActivity().supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    R.id.fragment_container_view,
                    PokemonDetailFragment.newInstance(characters[position].id),
                )
                addToBackStack(null)
            }
        }
        binding.pokemonRecyclerView.adapter = adapter

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}