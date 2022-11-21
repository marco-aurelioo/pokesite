package com.pokesite.site.pokesite.resources.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.pokesite.site.pokesite.domain.model.PokemonModel
import com.pokesite.site.pokesite.resources.api.extensions.toPokemonItem
import com.pokesite.site.pokesite.resources.api.model.Pokemon
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity


@Component
class PokemonAPI {

    var limit = 30

    fun findPokemonList(page: Int): List<PokemonModel> {
        val restTemplate = RestTemplate()
        val response = restTemplate.getForEntity<com.pokesite.site.pokesite.resources.api.model.PokemonPage>("https://pokeapi.co/api/v2/pokemon?limit=$limit&offset=${limit*page}")
        return response.body!!.results!!.stream().map {
            it.toPokemonItem()
        }.toList()
    }

    fun getPokemonById(pokemonId: Int): Pokemon {
        val restTemplate = RestTemplate()
        val response = restTemplate.getForEntity<Pokemon>("https://pokeapi.co/api/v2/pokemon/$pokemonId/")
        return response.body!!
    }

}