package com.pokemon.SpiderModel.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="omegarudy_alhasaphire")
data class OmegarubyAlphasapphire(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
)