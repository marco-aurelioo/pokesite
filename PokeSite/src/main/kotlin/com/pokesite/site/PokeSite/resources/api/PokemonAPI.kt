package com.pokesite.site.PokeSite.resources.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.pokesite.site.PokeSite.domain.model.Pokemon
import com.pokesite.site.PokeSite.domain.model.PokemonItem
import com.pokesite.site.PokeSite.domain.model.PokemonPage
import com.pokesite.site.PokeSite.resources.api.extensions.toPokemonItem
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity


@Component
class PokemonAPI {

    var mapper = ObjectMapper()

    fun getPokemon(): Pokemon{
        val restTemplate = RestTemplate()
        val response = restTemplate.getForEntity<Pokemon>("https://pokeapi.co/api/v2/pokemon/1/")
        return response.body!!
    }

    fun findPokemonList(): List<PokemonItem> {
        val restTemplate = RestTemplate()
        val response = restTemplate.getForEntity<PokemonPage>("https://pokeapi.co/api/v2/pokemon")
        return response.body!!.results!!.stream().map {
            it.toPokemonItem()
        }.toList()
    }

}