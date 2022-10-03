package com.pokemon.SpiderModel.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="other")
data class Other(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val dream_world: DreamWorld,
    val home: Home,
    val officialArtwork: OfficialArtwork
)