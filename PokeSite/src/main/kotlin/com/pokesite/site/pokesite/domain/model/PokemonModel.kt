package com.pokesite.site.pokesite.domain.model
data class PokemonModel(
    val id: Int?,
    val pokemonName: String? = "Novo",
    val pokemonImg: String?,
    val moves:Int?,
    val weight: Int?,
    val height: Int?,
    val hp: Int?,
    val attack: Int?,
    val defense: Int?,
    val specialAttack: Int?,
    val specialDefense: Int?,
    val speed: Int?,
    val types: List<PokemonTypeModel>?,
    val imgs: List<String?>?
)