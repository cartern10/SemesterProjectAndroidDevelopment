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
        inflater: LayoutInflater,
        container: ViewGroup?,
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
            location = "Reserve",
            loyalty = 5,
            info = "The Warrant officer in charge of supply warehouses on the sustaining base enforcing the Norvinsk region blockade. Secretly supplied the BEAR PMC operators with weapons, ammunition, and various other provisions he had at his disposal during the Contract Wars."
        )
        traders.add(traderPrapor)

        val traderTherapist = Trader(
            name = "Therapist",
            id = 1,
            image = "https://static.wikia.nocookie.net/escapefromtarkov_gamepedia/images/3/39/TherapistFullRes.jpg/revision/latest/scale-to-width-down/1000?cb=20180417001233",
            trader_category = "Medical Supplies",
            location = "Customs",
            loyalty = 3,
            info = "Head of the Trauma Care Department of the Tarkov Central City Hospital."
        )
        traders.add(traderTherapist)

        val traderFence = Trader(
            name = "Fence",
            id = 1,
            image = "https://static.wikia.nocookie.net/escapefromtarkov_gamepedia/images/0/0f/FenceFullRes.png/revision/latest/scale-to-width-down/1000?cb=20190224001434",
            trader_category = "Random Root",
            location = "Unknown",
            loyalty = 3,
            info = "The conflict had barely started when Fence began setting up anonymous outlets for buying and selling goods. Keeping incognito, he nevertheless managed to put together a well-organised smuggler network, operating all over the Norvinsk region."
        )
        traders.add(traderFence)

        val traderSkier = Trader(
            name = "Skier",
            id = 1,
            image = "https://static.wikia.nocookie.net/escapefromtarkov_gamepedia/images/e/e9/SkierFullRes.jpg/revision/latest/scale-to-width-down/1000?cb=20180417001355",
            trader_category = "Weapon attachments",
            location = "Shoreline",
            loyalty = 2,
            info = "Previously a port zone customs terminal employee, who initially oversaw dealings of the terminal's goods. Over the course of the conflict, he put together a gang of thugs in order to grab everything of value that he could lay his hands on in the vicinity of the terminal."
        )
        traders.add(traderSkier)

        val traderPeacekeeper = Trader(
            name = "Peacekeeper",
            id = 1,
            image = "https://static.wikia.nocookie.net/escapefromtarkov_gamepedia/images/d/dd/PeacekeeperFullRes.jpg/revision/latest/scale-to-width-down/1000?cb=20180417001502",
            trader_category = "US Weapons",
            location = "Shoreline",
            loyalty = 1,
            info = "UN peacekeeping Force supply officer, based in one of the central checkpoints leading to the Tarkov port zone. The blue helmets have been seen poking their heads into small deals from the very beginning of the conflict, buying everything of value in exchange for western weapons, ammo, and all kinds of military equipment."
        )
        traders.add(traderPeacekeeper)

        val traderMechanic = Trader(
            name = "Mechanic",
            id = 1,
            image = "https://static.wikia.nocookie.net/escapefromtarkov_gamepedia/images/0/0d/Sergey_Arsenyevich_Samoylov.jpg/revision/latest/scale-to-width-down/1000?cb=20180417001534",
            trader_category = "Weapon attachments",
            location = "Reserve",
            loyalty = 3,
            info = "A former chemical plant foreman, who from the very beginning of the conflict took to weapon modification, repairs, and maintenance of complex equipment and technology. He prefers clandestine solo living and operates discreetly, while placing complicated and challenging tasks above all else."
        )
        traders.add(traderMechanic)

        val traderRagman = Trader(
            name = "Ragman",
            id = 1,
            image = "https://static.wikia.nocookie.net/escapefromtarkov_gamepedia/images/7/71/Ragpickerbanner.jpg/revision/latest/scale-to-width-down/1000?cb=20180417002456",
            trader_category = "Clothing & Armor",
            location = "Interchange",
            loyalty = 3,
            info = "Previously, he worked as a director in a shopping center located in the suburbs of Tarkov. Now dealing in mostly clothing- and gear-related items, anywhere from sunglasses to body armor."
        )
        traders.add(traderRagman)

        val traderJaeger = Trader(
            name = "Jaeger",
            id = 1,
            image = "https://static.wikia.nocookie.net/escapefromtarkov_gamepedia/images/b/bd/Jaeger.jpg/revision/latest/scale-to-width-down/1000?cb=20190214161011",
            trader_category = "Camping Supplies",
            location = "Woods",
            loyalty = 6,
            info = "Before the conflict, he worked as a hunter in the Priozersk Natural Reserve under the State Hunting Service. A professional hunter and survival specialist. Even now, he still guards the reserve's hunting grounds from various aggressive individuals."
        )
        traders.add(traderJaeger)

        val traderLightKeeper = Trader(
            name = "LightKeeper",
            id = 1,
            image = "https://static.wikia.nocookie.net/escapefromtarkov_gamepedia/images/e/e1/LightkeeperInfobox.png/revision/latest?cb=20230123191336",
            trader_category = "None",
            location = "Lighthouse",
            loyalty = 1,
            info = "The current Tarkov Lighthouse warden, a specialist in radio and naval electronic devices."
        )
        traders.add(traderLightKeeper)


        val adapter = TraderAdapter(traders)
        recyclerView.adapter = adapter

        return view
    }
}