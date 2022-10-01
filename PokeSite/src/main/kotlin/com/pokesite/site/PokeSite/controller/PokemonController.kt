package com.pokesite.site.PokeSite.controller

import com.pokesite.site.PokeSite.domain.service.PokemonService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class PokemonController(var pokemonService: PokemonService) {

    @GetMapping("/{pokemon}")
    fun  getPokemonByName(
        @PathVariable("pokemon") pokemonName: String,
        model: Model
    ): String{
        model.addAllAttributes(
            mapOf(
                "pokemonName" to pokemonName,
                "pokemon" to pokemonService.findPokemonByName(pokemonName)))

        return "pokemon"
    }

}