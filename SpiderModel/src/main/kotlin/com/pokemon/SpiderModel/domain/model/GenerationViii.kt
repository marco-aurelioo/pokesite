package com.pokemon.SpiderModel.model

import javax.persistence.*

@Entity
@Table(name="generation_viii")
data class GenerationViii(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val icons: Icons
)