package com.pokesite.site.pokesite.resources.api.model

import com.fasterxml.jackson.annotation.JsonAlias

data class GenerationV(
    @JsonAlias("black-white")
    val blackWhite: BlackWhite?
)