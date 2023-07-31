package com.pokesite.site.pokesite.controller

import com.pokesite.site.pokesite.domain.service.PokemonService
import com.pokesite.site.pokesite.domain.service.PublicidadeService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.servlet.ModelAndView

@Controller
class PokemonController(
    var pokemonService: PokemonService,
    var publicidadeService: PublicidadeService ) {

    @GetMapping("/{pokemon}")
    fun getPokemonByName(
        @PathVariable("pokemon") pokemonName: String,
        model: Model
    ): String{
        if(pokemonName.equals("favicon.ico"))
            return "blank"

        model.addAttribute("pokemon" , pokemonService.findPokemonByName(pokemonName))
        model.addAttribute("publicidadeList",publicidadeService.findPublicidade(pokemonName))

        return "pokemon"
    }

    @GetMapping("/new/{pokemonId}")
    fun getPokemonByName(
        @PathVariable("pokemonId") pokemonId: Int,
        model: Model
    ): String {

        model.addAttribute("pokemon" , pokemonService.findPokemonById(pokemonId))
        model.addAttribute("publicidadeList",publicidadeService.findPublicidade("pokemonId: $pokemonId"))

        return "pokemon"
    }

}