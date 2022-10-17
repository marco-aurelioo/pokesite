package com.pokesite.site.pokesite.domain.service

import com.pokesite.site.pokesite.domain.model.PokemonModel
import com.pokesite.site.pokesite.resources.api.model.Pokemon
import com.pokesite.site.pokesite.resources.api.model.PokemonItem
import com.pokesite.site.pokesite.resources.api.PokemonAPI
import com.pokesite.site.pokesite.resources.persistence.PokemonStore
import org.springframework.stereotype.Service

@Service
class PokemonService( var pokemonAPI: PokemonAPI,
    var pokemonStore: PokemonStore ) {

    fun findPokemonByName(name: String): Pokemon {

        val pokemon = pokemonAPI.getPokemon()
        pokemonStore.savePokemonModel(pokemon)
        return pokemon
    }

    fun findPokemonList(): List<PokemonModel> {
        return pokemonStore.finPokemonModelList(
            pokemonAPI.findPokemonList())
    }
}