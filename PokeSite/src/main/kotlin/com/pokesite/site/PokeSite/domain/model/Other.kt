package com.pokesite.site.PokeSite.domain.model

import com.fasterxml.jackson.annotation.JsonAlias

data class Other(
    val dream_world: DreamWorld?,
    val home: Home?,
    @JsonAlias("official-artwork")
    val official_artwork: OfficialArtwork?
)