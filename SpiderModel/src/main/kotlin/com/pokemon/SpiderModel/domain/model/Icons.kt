package com.pokemon.SpiderModel.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="icons")
data class Icons(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val front_default: String?,
    val front_female: String?
)