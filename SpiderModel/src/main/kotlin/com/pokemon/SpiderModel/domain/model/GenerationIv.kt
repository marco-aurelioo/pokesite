package com.pokemon.SpiderModel.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="generation_iv")
data class GenerationIv(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val diamondPearl: DiamondPearl,
    val heartgoldSoulsilver: HeartgoldSoulsilver,
    val platinum: Platinum
)