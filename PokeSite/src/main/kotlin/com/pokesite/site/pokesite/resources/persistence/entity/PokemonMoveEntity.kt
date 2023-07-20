package com.pokesite.site.pokesite.resources.persistence.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "pokemon_moves")
data class PokemonMoveEntity(
    @Id
    val id: Int?,
    val externalId: Int,
    val moveName: String?,
    val active: Boolean?,
    val motionPicture: String?,
    val speed: Int?,
    val attack: Int?,
    val defense: Int?,
    @ManyToMany(mappedBy = "moves")
    val pokemons: List<PokemonEntity>?)