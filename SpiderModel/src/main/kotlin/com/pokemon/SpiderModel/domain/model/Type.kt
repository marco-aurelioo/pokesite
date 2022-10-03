package com.pokemon.SpiderModel.domain.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.pokemon.SpiderModel.domain.model.Pokemon
import javax.persistence.*

@Entity
@Table(name="type")
@JsonIgnoreProperties(ignoreUnknown = true)
data class Type(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Int,
    val slot: Int,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="typex_id")
    val type: TypeX,
    @ManyToOne
    @JoinColumn(name="pokemon_id")
    val pokemon: Pokemon
)