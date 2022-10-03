package com.pokemon.SpiderModel.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="red_blue")
data class RedBlue(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val back_default: String?,
    val back_gray: String?,
    val back_transparent: String?,
    val front_default: String?,
    val front_gray: String?,
    val front_transparent: String?
)