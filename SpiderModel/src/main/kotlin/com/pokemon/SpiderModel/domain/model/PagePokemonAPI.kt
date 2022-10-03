package com.pokemon.domain.model

import javax.persistence.*

@Entity
@Table(name="page")
data class PagePokemonAPI(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val count: Int?,
    val next: String?,
    val previous: String?,
    val results: List<PokemonBase>?
)