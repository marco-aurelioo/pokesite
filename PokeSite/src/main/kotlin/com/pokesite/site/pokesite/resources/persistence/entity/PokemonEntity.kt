package com.pokesite.site.pokesite.resources.persistence.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "pokemon")
data class PokemonEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val externalId: Int,
    val pokemonName: String ,
    val pokemonImg: String,
    val weight: Int?,
    val height: Int?,
    val hp: Int?,
    val attack: Int?,
    val defense: Int?,
    val specialAttack: Int?,
    val specialDefense: Int?,
    val speed: Int?)