package com.pokemon.SpiderModel.model

import com.pokemon.SpiderModel.domain.model.Pokemon
import javax.persistence.*

@Entity
@Table(name="type")
data class Type(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Int,
    val slot: Int,
    val type: TypeX,
    @ManyToOne
    @JoinColumn(name="pokemon_id")
    val pokemon: Pokemon
)