package com.pokemon.SpiderModel.model

import com.pokemon.SpiderModel.domain.model.Pokemon
import javax.persistence.*

@Entity
@Table(name = "ability")
data class Ability (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val isHidden: Boolean,
    val slot: Int,
    @Embedded
    val ability: NameUrlModel,
    @ManyToOne
    @JoinColumn(name="pokemon_id")
    val pokemon: Pokemon
)
