package com.pokemon.SpiderModel.model

import javax.persistence.*

@Entity
@Table(name="heartgoldSoulsilver")
data class HeartgoldSoulsilver(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val back_default: String?,
    val back_female: String?,
    val back_shiny: String?,
    val back_shiny_female: String?,
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
)