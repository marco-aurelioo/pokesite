package com.pokemon.domain.model

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

data class PokemonBase(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: String?,
    val url: String )
