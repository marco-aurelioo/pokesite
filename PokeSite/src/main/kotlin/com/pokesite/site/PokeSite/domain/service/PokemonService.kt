package com.pokesite.site.PokeSite.domain.service

import com.pokesite.site.PokeSite.domain.model.Pokemon
import com.pokesite.site.PokeSite.resources.api.PokemonAPI
import org.springframework.stereotype.Service

@Service
class PokemonService( var pokemonAPI: PokemonAPI) {

    fun findPokemonByName(name: String): Pokemon{
        val pokemon = pokemonAPI.getPokemon()
        println("valor: ${pokemon.sprites!!.other!!.official_artwork!!.front_default}")
        return pokemon
    }
}