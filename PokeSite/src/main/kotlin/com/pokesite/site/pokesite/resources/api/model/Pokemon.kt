package com.pokesite.site.pokesite.resources.api.model

data class Pokemon(
    val abilities: List<com.pokesite.site.pokesite.resources.api.model.Ability>?,
    val base_experience: Int?,
    val forms: List<com.pokesite.site.pokesite.resources.api.model.Form>?,
    val game_indices: List<com.pokesite.site.pokesite.resources.api.model.GameIndice>?,
    val height: Int?,
    val held_items: List<String?>?,
    val id: Int,
    val is_default: Boolean?,
    val location_area_encounters: String?,
    val moves: List<com.pokesite.site.pokesite.resources.api.model.Move>?,
    val name: String?,
    val order: Int?,
    val past_types: List<String?>?,
    val species: com.pokesite.site.pokesite.resources.api.model.Species?,
    val sprites: com.pokesite.site.pokesite.resources.api.model.Sprites?,
    val stats: List<com.pokesite.site.pokesite.resources.api.model.Stat>?,
    val types: List<com.pokesite.site.pokesite.resources.api.model.Type>?,
    val weight: Int?
)