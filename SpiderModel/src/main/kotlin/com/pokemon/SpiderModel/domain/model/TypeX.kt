package com.pokemon.SpiderModel.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="type_x")
data class TypeX(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: String?,
    val url: String?
)