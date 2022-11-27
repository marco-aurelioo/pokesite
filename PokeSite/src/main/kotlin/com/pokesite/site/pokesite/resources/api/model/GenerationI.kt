package com.pokesite.site.pokesite.resources.api.model

import com.fasterxml.jackson.annotation.JsonAlias

data class GenerationI(
    @JsonAlias("red-blue")
    val redBlue: RedBlue?,
    val yellow: Yellow?
)