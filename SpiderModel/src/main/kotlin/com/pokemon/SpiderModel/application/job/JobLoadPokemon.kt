package com.pokemon.SpiderModel.application.job

import com.fasterxml.jackson.databind.ObjectMapper
import com.pokemon.SpiderModel.domain.model.PagePokemonAPI
import com.pokemon.SpiderModel.domain.model.Pokemon
import com.pokemon.SpiderModel.resources.PokemonBaseRepository
import com.pokemon.SpiderModel.resources.PokemonRepository
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity

@Component
class JobLoadPokemon(
    var baseRepository: PokemonBaseRepository,
    var repository: PokemonRepository
) {

    var restTemplate = RestTemplate()
    var objectMapper = ObjectMapper()

    @Scheduled(fixedDelay = 30000 )
    fun runJob() {
        var baselist = baseRepository.findByLoad(false)
        baselist.forEach {
            println(it.url)
            var pokemon = getPage( it.url!!)
            repository.save(pokemon)
             baseRepository.save(it.copy(load = true))
        }

    }

    fun getPage(url: String): Pokemon {
        var response = restTemplate.getForEntity<String>(url)
        return objectMapper.readValue(response.body, Pokemon::class.java)
    }

}