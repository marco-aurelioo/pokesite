package com.pokesite.site.pokesite.resources.api.model

import com.fasterxml.jackson.annotation.JsonAlias

data class GenerationVii(
    val icons: Icons?,
    @JsonAlias("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: UltraSunUltraMoon?
)