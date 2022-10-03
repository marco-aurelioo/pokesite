package com.pokemon.SpiderModel.domain.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
@Entity
@Table(name="forms")
@JsonIgnoreProperties(ignoreUnknown = true)
data class Forms(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: String?,
    val url: String?,
    @ManyToOne
    @JoinColumn(name="pokemon_id")
    val pokemon: Pokemon
)
