package com.pokesite.site.pokesite.resources.api.model

data class Ability(
    val ability: com.pokesite.site.pokesite.resources.api.model.AbilityX?,
    val is_hidden: Boolean?,
    val slot: Int?
)