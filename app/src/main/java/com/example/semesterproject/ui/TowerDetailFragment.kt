package com.example.semesterproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.semesterproject.databinding.FragmentTowerDetailBinding
import com.example.semesterproject.viewmodel.TowerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TowerDetailFragment : Fragment() {

    private var _binding: FragmentTowerDetailBinding? = null
    private val binding get() = _binding!!

    private val towerViewModel: TowerViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTowerDetailBinding.inflate(inflater, container, false)

        if(arguments != null){
//            val tower = towerViewModel.fetchById(requireArguments().getInt(BUNDLE_ID))

//            Glide.with(requireContext()).load(tower.image).into(binding.towerImage)
//            binding.towerName.text = getString(R.string.name, tower.name)
        }
        return binding.root
    }

    //static
    companion object{
        private const val BUNDLE_ID = "id"

        //This can be changed
        fun newInstance(id: String): TowerDetailFragment {
            val detailFragment = TowerDetailFragment()
            detailFragment.arguments = bundleOf(BUNDLE_ID to id)
            return detailFragment
        }
    }
}