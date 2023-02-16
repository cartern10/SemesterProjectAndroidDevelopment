package com.example.semesterproject.UI

import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.semesterproject.R

class TraderDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_trader_detail, container, false)

        if(arguments != null){
            val name = requireArguments().getString("name")

            val image = requireArguments().getString("image")
            //val category = requireArguments().getString("category")
            val location = requireArguments().getString("location")
            val info = requireArguments().getString("info")
            val rep = requireArguments().getInt("rep")

            Glide.with(this).load(image).into(view.findViewById(R.id.trader_image))

            view.findViewById<TextView>(R.id.player_level_rep).text = "Player's Level for Max Reputation: " + rep.toString()
            view.findViewById<TextView>(R.id.trader_name).text = name
            view.findViewById<TextView>(R.id.trader_location).text = "Location: " + location
            view.findViewById<TextView>(R.id.trader_info).text = "Bio: " + info
        }
        return view
    }
}