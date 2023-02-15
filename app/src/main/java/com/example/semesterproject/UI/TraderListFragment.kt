package com.example.semesterproject.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.semesterproject.R
import com.example.semesterproject.Trader
import com.example.semesterproject.TraderAdapter

class TraderListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_trader_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.trader_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val traders = mutableListOf<Trader>()

        val traderPrapor = Trader(
            name = "Prapor",
            id = 1,
            image = "https://static.wikia.nocookie.net/escapefromtarkov_gamepedia/images/f/f6/PraporFullRes.jpg/revision/latest/scale-to-width-down/1000?cb=20180417001021",
            trader_category = "Grenades & AKs",
            location = "Unknown",
            loyalty = 5
        )
        traders.add(traderPrapor)

        val traderTherapist = Trader(
            name = "Therapist",
            id = 1,
            image = R.drawable.baseline_10k_24,
            trader_category = "Medical Supplies",
            location = "Unknown",
            loyalty = 3
        )
        traders.add(traderTherapist)

        val traderFence = Trader(
            name = "Fence",
            id = 1,
            image = R.drawable.baseline_10k_24,
            trader_category = "Random Root",
            location = "Unknown ",
            loyalty = 3
        )
        traders.add(traderFence)

        val traderSkier = Trader(
            name = "Skier",
            id = 1,
            image = R.drawable.baseline_10k_24,
            trader_category = "Weapon attachments",
            location = "Unknown",
            loyalty = 2
        )
        traders.add(traderSkier)

        val traderPeacekeeper = Trader(
            name = "Peacekeeper",
            id = 1,
            image = R.drawable.baseline_10k_24,
            trader_category = "US Weapons",
            location = "Unknown",
            loyalty = 1
        )
        traders.add(traderPeacekeeper)

        val traderMechanic = Trader(
            name = "Mechanic",
            id = 1,
            image = R.drawable.baseline_10k_24,
            trader_category = "Weapon attachments",
            location = "Unknown",
            loyalty = 3
        )
        traders.add(traderMechanic)

        val traderRagman = Trader(
            name = "Ragman",
            id = 1,
            image = R.drawable.baseline_10k_24,
            trader_category = "Clothing & Armor",
            location = "Unknown",
            loyalty = 3
        )
        traders.add(traderRagman)

        val traderYaeger = Trader(
            name = "Yaeger",
            id = 1,
            image = R.drawable.baseline_10k_24,
            trader_category = "Camping Supplies",
            location = "Unknown",
            loyalty = 6
        )
        traders.add(traderYaeger)

        val traderLightKeeper = Trader(
            name = "LightKeeper",
            id = 1,
            image = R.drawable.baseline_10k_24,
            trader_category = "None",
            location = "Shoreline",
            loyalty = 1
        )
        traders.add(traderLightKeeper)


        val adapter = TraderAdapter(traders)
        recyclerView.adapter = adapter

        return view
    }
}