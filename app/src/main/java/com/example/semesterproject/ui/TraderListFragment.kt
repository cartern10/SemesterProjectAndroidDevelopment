package com.example.semesterproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.semesterproject.R
import com.example.semesterproject.Trader
import com.example.semesterproject.TraderAdapter
import com.example.semesterproject.viewmodel.TraderViewModel

class TraderListFragment : Fragment() {

    private val traderViewModel: TraderViewModel //this

    private var traderViewHolder: TraderViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //bind
        val trader = traderViewModel.fetchById(requireArguments().getInt(BUNDLE_ID))

        binding.trader

        val trader = TraderViewModel.fillData()
        val view = inflater.inflate(R.layout.fragment_trader_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.trader_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val traders = mutableListOf<Trader>()

        val adapter = TraderAdapter(traders)
        recyclerView.adapter = adapter


        return view
    }
}