package com.pokemon.SpiderModel.domain.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name="generation_iv")
@JsonIgnoreProperties(ignoreUnknown = true)
data class GenerationIv(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="diamondpearl_id")
    val diamondPearl: DiamondPearl,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="heartgoldsoulsilver_id")
    val heartgoldSoulsilver: HeartgoldSoulsilver,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="platinum_id")
    val platinum: Platinum
)