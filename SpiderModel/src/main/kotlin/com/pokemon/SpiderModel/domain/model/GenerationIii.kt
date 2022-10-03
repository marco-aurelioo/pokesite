package com.pokemon.SpiderModel.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="generation_iii")
data class GenerationIii(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val emerald: Emerald,
    val fireredLeafgreen: FireredLeafgreen,
    val rubySapphire: RubySapphire
)