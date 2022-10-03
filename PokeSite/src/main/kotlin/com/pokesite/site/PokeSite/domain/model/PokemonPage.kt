package com.pokesite.site.PokeSite.domain.model

data class PokemonPage(
    val count: Int?,
    val next: String?,
    val previous: Any?,
    val results: List<Result>?
)