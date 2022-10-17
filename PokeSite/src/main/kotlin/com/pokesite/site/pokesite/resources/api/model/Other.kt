package com.pokesite.site.pokesite.resources.api.model

import com.fasterxml.jackson.annotation.JsonAlias

data class Other(
    val dream_world: com.pokesite.site.pokesite.resources.api.model.DreamWorld?,
    val home: com.pokesite.site.pokesite.resources.api.model.Home?,
    @JsonAlias("official-artwork")
    val official_artwork: com.pokesite.site.pokesite.resources.api.model.OfficialArtwork?
)