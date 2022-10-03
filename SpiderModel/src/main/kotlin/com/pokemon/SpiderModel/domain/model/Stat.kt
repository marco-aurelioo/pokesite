package com.pokemon.SpiderModel.model

import com.pokemon.SpiderModel.domain.model.Pokemon
import javax.persistence.*
@Entity
@Table(name="Stat")
data class Stat(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Int,
    val base_stat: Int,
    val effort: Int,
    val stat: StatX,
    @ManyToOne
@JoinColumn(name="pokemon_id")
val pokemon: Pokemon
)