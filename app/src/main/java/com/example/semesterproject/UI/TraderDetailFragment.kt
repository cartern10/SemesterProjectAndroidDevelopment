package com.example.semesterproject.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.semesterproject.R

class TraderDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_trader_detail, container, false)

        if(arguments != null){
            val name = requireArguments().getString("name")
            val category = requireArguments().getString("category")
            val location = requireArguments().getString("location")
            val loyalty = requireArguments().getString("loyalty")

            view.findViewById<TextView>(R.id.trader_info).text = info
        }

        return view
    }
}