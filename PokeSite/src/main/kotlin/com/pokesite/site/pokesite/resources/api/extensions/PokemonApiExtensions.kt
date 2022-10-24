package com.pokesite.site.pokesite.resources.api.extensions

import com.pokesite.site.pokesite.domain.model.PokemonModel
import com.pokesite.site.pokesite.resources.api.model.Pokemon

class PokemonApiExtensions {
}

fun com.pokesite.site.pokesite.resources.api.model.Result.toPokemonItem(): PokemonModel {
    return PokemonModel(
        id = this.url.extractUrlId(),
        pokemonImg = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/${this.url.extractUrlId()}.svg",
        pokemonName = this.name,
        moves = null
    )
}

fun Pokemon.toPokemonModel(): PokemonModel {
    return PokemonModel(
        id = this.id,
        pokemonImg = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/${this.id}.svg",
        pokemonName = this.name,
        moves = null
    )

}

fun String.extractUrlId(): Int {
    return this.replace(Regex("https://pokeapi.co/api/v2/pokemon/(\\d+)/"),"$1").toInt()
}