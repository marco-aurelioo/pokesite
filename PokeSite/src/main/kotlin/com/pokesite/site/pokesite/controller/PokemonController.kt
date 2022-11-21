package com.pokesite.site.pokesite.controller

import com.pokesite.site.pokesite.domain.service.PokemonService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.servlet.ModelAndView

@Controller
class PokemonController(var pokemonService: PokemonService) {

    @GetMapping("/{pokemon}")
    fun getPokemonByName(
        @PathVariable("pokemon") pokemonName: String,
        model: Model
    ): String{
        if(pokemonName.equals("favicon.ico"))
            return "blank"
        model.addAttribute("pokemon" , pokemonService.findPokemonByName(pokemonName))
        return "pokemon"
    }

    @GetMapping("/new/{pokemonId}")
    fun getPokemonByName(
        @PathVariable("pokemonId") pokemonId: Int,
        model: ModelAndView
    ): ModelAndView {
        val pokemon = pokemonService.findPokemonById(pokemonId)
        return ModelAndView(
            "pokemon",
            mutableMapOf("pokemon" to pokemon)
        )
    }

}