package com.pokemon.SpiderModel.domain.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.pokemon.SpiderModel.domain.model.Pokemon
import javax.persistence.*
@Entity
@Table(name="Stat")
@JsonIgnoreProperties(ignoreUnknown = true)
data class Stat(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Int,
    val base_stat: Int,
    val effort: Int,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="statx_id")
    val stat: StatX,
    @ManyToOne
@JoinColumn(name="pokemon_id")
val pokemon: Pokemon
)