package com.pokesite.site.pokesite.controller

import com.pokesite.site.pokesite.domain.service.PokemonService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class HomeController(var pokemonService: PokemonService) {

    @GetMapping("/")
    fun getHome(
        @RequestParam(name = "page", required = false, defaultValue = "0")  page: Int =0,
        model: Model):String{
        val listPokemon = pokemonService.findPokemonList(page)
        model.addAttribute("nextPage",page + 1)
        model.addAttribute("previousPage",page - 1)
        model.addAttribute("listPokemon",listPokemon)
        return "index"
    }



}