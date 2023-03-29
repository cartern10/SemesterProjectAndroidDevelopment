package com.example.semesterproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.semesterproject.databinding.FragmentTraderDetailBinding
import com.example.semesterproject.viewmodel.TraderViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TraderDetailFragment : Fragment() {

    private var _binding: FragmentTraderDetailBinding? = null
    private val binding get() = _binding!!

    private val traderViewModel: TraderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTraderDetailBinding.inflate(inflater, container, false)

        if(arguments != null){
            val trader = traderViewModel.fetchById(requireArguments().getInt(BUNDLE_ID))

            Glide.with(requireContext()).load(trader.image).into(binding.traderImage)
            binding.traderName.text = "Name: {trader.name}"
        }
        return binding.root
    }

    //static
    companion object{
        private const val BUNDLE_ID = "id"

        //This can be changed
        fun newInstance(id: Int): TraderDetailFragment {
            val detailFragment = TraderDetailFragment()
            detailFragment.arguments = bundleOf(BUNDLE_ID to id)
            return detailFragment
        }
    }
}