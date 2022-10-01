package com.pokesite.site.PokeSite.domain.model

data class Pokemon(
    val abilities: List<Ability>?,
    val base_experience: Int?,
    val forms: List<Form>?,
    val game_indices: List<GameIndice>?,
    val height: Int?,
    val held_items: List<String?>?,
    val id: Int,
    val is_default: Boolean?,
    val location_area_encounters: String?,
    val moves: List<Move>?,
    val name: String?,
    val order: Int?,
    val past_types: List<String?>?,
    val species: Species?,
    val sprites: Sprites?,
    val stats: List<Stat>?,
    val types: List<Type>?,
    val weight: Int?
)