package com.pokemon.SpiderModel.domain.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name="generation_vii")
@JsonIgnoreProperties(ignoreUnknown = true)
data class GenerationVii(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="icons_id")
    val icons: Icons,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="ultrasunultramon_id")
    val ultraSunUltraMoon: UltraSunUltraMoon
)