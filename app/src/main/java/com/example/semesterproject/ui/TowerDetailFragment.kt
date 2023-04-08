package com.example.semesterproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.semesterproject.R
import com.example.semesterproject.data.TowerApi
import com.example.semesterproject.data.model.TowerResponse
import com.example.semesterproject.data.repository.TowerRepository
import com.example.semesterproject.databinding.FragmentTowerDetailBinding
import com.example.semesterproject.model.Tower
import com.example.semesterproject.ui.adapter.TowerAdapter
import com.example.semesterproject.viewmodel.TowerDetailModel
import com.example.semesterproject.viewmodel.TowerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TowerDetailFragment : Fragment() {

    private var _binding: FragmentTowerDetailBinding? = null
    private val binding get() = _binding!!



    private val towerDetailModel: TowerDetailModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTowerDetailBinding.inflate(inflater, container, false)

        if(arguments != null){
            val towerId = requireArguments().getString(BUNDLE_ID)

             binding.towerName.text = getString(R.string.name, towerId)
            // binding.towerDescription.text = tower.toString()
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