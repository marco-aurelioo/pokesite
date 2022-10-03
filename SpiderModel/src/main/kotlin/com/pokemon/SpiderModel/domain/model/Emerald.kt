package com.pokemon.SpiderModel.domain.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="emerald")
@JsonIgnoreProperties(ignoreUnknown = true)
data class Emerald(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val front_default: String?,
    val front_shiny: String?
)