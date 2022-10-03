package com.pokesite.site.PokeSite.controller

import com.pokesite.site.PokeSite.domain.service.PokemonService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController(var pokemonService: PokemonService) {

    @GetMapping("/index.html")
    fun getHome(model: Model):String{
        val listPokemon = pokemonService.findPokemonList()
        model.addAttribute("listPokemon",listPokemon)
        return "index"
    }

}