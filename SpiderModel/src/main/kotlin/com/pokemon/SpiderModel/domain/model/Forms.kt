package com.pokemon.SpiderModel.model

import com.pokemon.SpiderModel.domain.model.Pokemon
import javax.persistence.*
@Entity
@Table(name="forms")
data class Forms(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @Embedded
    val forms: NameUrlModel,
    @ManyToOne
    @JoinColumn(name="pokemon_id")
    val pokemon: Pokemon
)
