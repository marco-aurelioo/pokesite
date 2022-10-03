package com.pokesite.site.PokeSite.resources.api.extensions

import com.pokesite.site.PokeSite.domain.model.PokemonItem
import com.pokesite.site.PokeSite.domain.model.Result

class PokemonApiExtensions {
}

fun Result.toPokemonItem():PokemonItem {
    return PokemonItem(
        id = this.url.extractUrlId(),
        pokemonImg = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${this.url.extractUrlId()}.png"
    )
}

fun String.extractUrlId(): Int {
    return this.replace(Regex("https://pokeapi.co/api/v2/pokemon/(\\d+)/"),"$1").toInt()
}