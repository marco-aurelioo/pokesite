package com.pokesite.site.pokesite.resources.api.model

import com.fasterxml.jackson.annotation.JsonAlias

data class GenerationIv(
    @JsonAlias("diamond-pearl")
    val diamondPearl: DiamondPearl?,
    @JsonAlias("heartgold-soulsilver")
    val heartgoldSoulsilver: HeartgoldSoulsilver?,
    val platinum: Platinum?
)