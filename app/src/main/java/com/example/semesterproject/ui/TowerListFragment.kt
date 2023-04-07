package com.example.semesterproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.semesterproject.R
import com.example.semesterproject.databinding.FragmentTowerListBinding

import com.example.semesterproject.ui.adapter.TowerAdapter
import com.example.semesterproject.viewmodel.TowerViewModel

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TowerListFragment : Fragment() {

    private var _binding: FragmentTowerListBinding? = null
    private val binding get() = _binding!!

    private val towerViewModel: TowerViewModel by activityViewModels()
    private val towerAdapter = TowerAdapter { tower, _ ->
        requireActivity().supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                R.id.fragment_container_view,
                TowerDetailFragment.newInstance(tower.id),
            )
            addToBackStack(null)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentTowerListBinding.inflate(inflater, container, false)
        binding.towerRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.towerRecyclerView.adapter = towerAdapter
        setupObservers()
        towerViewModel.fillData()
        return binding.root
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            towerViewModel.towers.collect { event ->
                when (event) {
                    TowerViewModel.TowerEvent.Failure -> {
                        binding.progressBar.isVisible = false
                        binding.towerRecyclerView.isVisible = false
                        binding.errorMessage.isVisible = true
                    }
                    TowerViewModel.TowerEvent.Loading -> {
                        binding.progressBar.isVisible = true
                        binding.towerRecyclerView.isVisible = false
                        binding.errorMessage.isVisible = false
                    }
                    is TowerViewModel.TowerEvent.Success -> {
                        towerAdapter.refreshData(event.towers)
                        binding.progressBar.isVisible = false
                        binding.errorMessage.isVisible = false
                        binding.towerRecyclerView.isVisible = true

                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}