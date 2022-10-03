package com.pokemon.SpiderModel.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="generation_vii")
data class GenerationVii(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val icons: Icons,
    val ultraSunUltraMoon: UltraSunUltraMoon
)