package com.pokesite.site.pokesite.resources.api.model

data class PokemonItem(
    val id: Int,
    val pokemonName: String = "Novo",
    val pokemonImg: String
)