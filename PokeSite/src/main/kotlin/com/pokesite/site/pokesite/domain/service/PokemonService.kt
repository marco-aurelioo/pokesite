package com.pokesite.site.pokesite.domain.service

import com.pokesite.site.pokesite.domain.model.PokemonModel
import com.pokesite.site.pokesite.resources.api.PokemonAPI
import com.pokesite.site.pokesite.resources.api.extensions.toPokemonModel
import com.pokesite.site.pokesite.resources.persistence.PokemonStore
import org.springframework.stereotype.Service

@Service
class PokemonService(
    var pokemonAPI: PokemonAPI,
    var pokemonStore: PokemonStore ) {

    fun findPokemonByName(name: String): PokemonModel? {
        return pokemonStore.findByName(name)
    }

    fun findPokemonList(page: Int): List<PokemonModel> {
        return pokemonStore.finPokemonModelList(
            pokemonAPI.findPokemonList(page))
    }

    fun findPokemonById(pokemonId: Int): PokemonModel {
        pokemonStore.findByPokemonId(pokemonId)?.let{
                return it
        } ?: run {
           val pokemon = pokemonAPI.getPokemonById(pokemonId)
            pokemonStore.savePokemonModel(pokemon)
            return pokemon.toPokemonModel()
        }
    }
}