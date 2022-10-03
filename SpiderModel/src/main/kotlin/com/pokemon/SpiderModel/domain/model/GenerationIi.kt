package com.pokemon.SpiderModel.model

import javax.persistence.*

@Entity
@Table(name="generation_ii")
data class GenerationIi(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val crystal: Crystal,
    val gold: Gold,
    val silver: Silver
)