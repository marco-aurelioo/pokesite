package com.pokesite.site.pokesite.domain.model
data class PokemonModel(
    val id: Int?,
    val pokemonName: String? = "Novo",
    val pokemonImg: String?,
    val moves: List<MoveModel>?
)