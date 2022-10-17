package com.pokesite.site.pokesite.resources.api.extensions

import com.pokesite.site.pokesite.domain.model.PokemonModel

class PokemonApiExtensions {
}

fun com.pokesite.site.pokesite.resources.api.model.Result.toPokemonItem(): PokemonModel {
    return PokemonModel(
        id = this.url.extractUrlId(),
        pokemonImg = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${this.url.extractUrlId()}.png",
        pokemonName = this.name,
        moves = null
    )
}

fun String.extractUrlId(): Int {
    return this.replace(Regex("https://pokeapi.co/api/v2/pokemon/(\\d+)/"),"$1").toInt()
}