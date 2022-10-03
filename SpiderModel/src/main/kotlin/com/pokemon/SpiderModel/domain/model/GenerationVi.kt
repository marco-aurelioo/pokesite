package com.pokemon.SpiderModel.model

import javax.persistence.*

@Entity
@Table(name="generation_vi")
data class GenerationVi(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val omegarubyAlphasapphire: OmegarubyAlphasapphire,
    val xy: XY
)