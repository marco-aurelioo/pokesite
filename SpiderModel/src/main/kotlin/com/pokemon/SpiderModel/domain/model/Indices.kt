package com.pokemon.SpiderModel.model

import com.pokemon.SpiderModel.domain.model.Pokemon
import javax.persistence.*

@Entity
@Table(name="indices")
data class Indices(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val gameIndex: Int,
    @Embedded
    val indices: NameUrlModel,
    @ManyToOne
    @JoinColumn(name="pokemon_id")
    val pokemon: Pokemon
)