package com.pokesite.site.PokeSite.domain.model

data class PokemonItem(
    val id: Int,
    val pokemonName: String = "Novo",
    val pokemonImg: String
)