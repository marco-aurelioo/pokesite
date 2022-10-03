package com.pokemon.SpiderModel.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="crystal")
data class Crystal(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val back_default: String?,
    val back_shiny: String?,
    val back_shiny_transparent: String?,
    val back_transparent: String?,
    val front_default: String?,
    val front_shiny: String?,
    val front_shiny_transparent: String?,
    val front_transparent: String?
)