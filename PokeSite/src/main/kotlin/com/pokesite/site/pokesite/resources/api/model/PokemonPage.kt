package com.pokesite.site.pokesite.resources.api.model

data class PokemonPage(
    val count: Int?,
    val next: String?,
    val previous: Any?,
    val results: List<com.pokesite.site.pokesite.resources.api.model.Result>?
)