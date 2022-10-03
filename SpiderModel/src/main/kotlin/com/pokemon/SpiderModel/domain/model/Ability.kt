package com.pokemon.SpiderModel.domain.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "ability")
@JsonIgnoreProperties(ignoreUnknown = true)
data class Ability (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val isHidden: Boolean,
    val slot: Int,
    val name: String?,
    val url: String?,
    @ManyToOne
    @JoinColumn(name="pokemon_id")
    val pokemon: Pokemon
)
