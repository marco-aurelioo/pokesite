package com.pokesite.site.pokesite.resources.api.model

import com.fasterxml.jackson.annotation.JsonAlias

data class GenerationVi(
    @JsonAlias("omegaruby-alphasapphire")
    val omegarubyAlphasapphire: OmegarubyAlphasapphire?,
    @JsonAlias("x-y")
    val xY: XY?
)