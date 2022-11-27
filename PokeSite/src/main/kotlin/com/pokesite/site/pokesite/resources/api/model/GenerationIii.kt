package com.pokesite.site.pokesite.resources.api.model

import com.fasterxml.jackson.annotation.JsonAlias

data class GenerationIii(
    val emerald: Emerald?,
    @JsonAlias("firered-leafgreen")
    val fireredLeafgreen: FireredLeafgreen?,
    @JsonAlias("ruby-sapphire")
    val rubySapphire: RubySapphire?
)