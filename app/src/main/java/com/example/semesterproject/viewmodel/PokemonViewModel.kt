package com.example.semesterproject.viewmodel

import androidx.lifecycle.ViewModel
import com.example.semesterproject.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor() : ViewModel() {

    private val pokemons = mutableListOf<Pokemon>()
    init{
        createpokemons()
    }

    fun fillData() = pokemons.toList()

    fun fetchById(id: Int) = pokemons.first { it.id == id }

    private fun createpokemons() {

        pokemons.add(
            Pokemon(
                name = "Prapor",
                id = 1,
                image = "https://static.wikia.nocookie.net/escapefromtarkov_gamepedia/images/f/f6/PraporFullRes.jpg/revision/latest/scale-to-width-down/1000?cb=20180417001021",
                pokemon_category = "Grenades & AKs",
                location = "Reserve",
                level_max_rep = 36,
                info = "The Warrant officer in charge of supply warehouses on the sustaining base enforcing the Norvinsk region blockade. Secretly supplied the BEAR PMC operators with weapons, ammunition, and various other provisions he had at his disposal during the Contract Wars."
            )
        )
        pokemons.add(
            Pokemon(
                name = "Therapist",
                id = 2,
                image = "https://static.wikia.nocookie.net/escapefromtarkov_gamepedia/images/3/39/TherapistFullRes.jpg/revision/latest/scale-to-width-down/1000?cb=20180417001233",
                pokemon_category = "Medical Supplies",
                location = "Customs",
                level_max_rep = 35,
                info = "Head of the Trauma Care Department of the Tarkov Central City Hospital."
            )
        )
        pokemons.add(
            Pokemon(
                name = "Fence",
                id = 3,
                image = "https://static.wikia.nocookie.net/escapefromtarkov_gamepedia/images/0/0f/FenceFullRes.png/revision/latest/scale-to-width-down/1000?cb=20190224001434",
                pokemon_category = "Random Root",
                location = "Unknown",
                level_max_rep = 1,
                info = "The conflict had barely started when Fence began setting up anonymous outlets for buying and selling goods. Keeping incognito, he nevertheless managed to put together a well-organised smuggler network, operating all over the Norvinsk region."
            )
        )
        pokemons.add(
            Pokemon(
                name = "Skier",
                id = 4,
                image = "https://static.wikia.nocookie.net/escapefromtarkov_gamepedia/images/e/e9/SkierFullRes.jpg/revision/latest/scale-to-width-down/1000?cb=20180417001355",
                pokemon_category = "Weapon attachments",
                location = "Shoreline",
                level_max_rep = 38,
                info = "Previously a port zone customs terminal employee, who initially oversaw dealings of the terminal's goods. Over the course of the conflict, he put together a gang of thugs in order to grab everything of value that he could lay his hands on in the vicinity of the terminal."
            )
        )
        pokemons.add(
            Pokemon(
                name = "Peacekeeper",
                id = 5,
                image = "https://static.wikia.nocookie.net/escapefromtarkov_gamepedia/images/d/dd/PeacekeeperFullRes.jpg/revision/latest/scale-to-width-down/1000?cb=20180417001502",
                pokemon_category = "US Weapons",
                location = "Shoreline",
                level_max_rep = 38,
                info = "UN peacekeeping Force supply officer, based in one of the central checkpoints leading to the Tarkov port zone. The blue helmets have been seen poking their heads into small deals from the very beginning of the conflict, buying everything of value in exchange for western weapons, ammo, and all kinds of military equipment."
            )
        )

        pokemons.add(
                Pokemon(
                name = "Mechanic",
                id = 6,
                image = "https://static.wikia.nocookie.net/escapefromtarkov_gamepedia/images/0/0d/Sergey_Arsenyevich_Samoylov.jpg/revision/latest/scale-to-width-down/1000?cb=20180417001534",
                pokemon_category = "Weapon attachments",
                location = "Reserve",
                level_max_rep = 40,
                info = "A former chemical plant foreman, who from the very beginning of the conflict took to weapon modification, repairs, and maintenance of complex equipment and technology. He prefers clandestine solo living and operates discreetly, while placing complicated and challenging tasks above all else."
            )
        )
        pokemons.add(
            Pokemon(
                name = "Ragman",
                id = 7,
                image = "https://static.wikia.nocookie.net/escapefromtarkov_gamepedia/images/7/71/Ragpickerbanner.jpg/revision/latest/scale-to-width-down/1000?cb=20180417002456",
                pokemon_category = "Clothing & Armor",
                location = "Interchange",
                level_max_rep = 42,
                info = "Previously, he worked as a director in a shopping center located in the suburbs of Tarkov. Now dealing in mostly clothing- and gear-related items, anywhere from sunglasses to body armor."
            )
        )
        pokemons.add(
                Pokemon(
                name = "Jaeger",
                id = 8,
                image = "https://static.wikia.nocookie.net/escapefromtarkov_gamepedia/images/b/bd/Jaeger.jpg/revision/latest/scale-to-width-down/1000?cb=20190214161011",
                pokemon_category = "Camping Supplies",
                location = "Woods",
                level_max_rep = 33,
                info = "Before the conflict, he worked as a hunter in the Priozersk Natural Reserve under the State Hunting Service. A professional hunter and survival specialist. Even now, he still guards the reserve's hunting grounds from various aggressive individuals."
            )
        )
        pokemons.add(
            Pokemon(
                name = "LightKeeper",
                id = 9,
                image = "https://static.wikia.nocookie.net/escapefromtarkov_gamepedia/images/e/e1/LightkeeperInfobox.png/revision/latest?cb=20230123191336",
                pokemon_category = "None",
                location = "Lighthouse",
                level_max_rep = 1,
                info = "The current Tarkov Lighthouse warden, a specialist in radio and naval electronic devices."
            )
        )
    }
}