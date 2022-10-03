package com.pokemon.SpiderModel.domain.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name="generation_i")
@JsonIgnoreProperties(ignoreUnknown = true)
data class GenerationI(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="redblue_id")
    val redBlue: RedBlue?,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="yellow_id")
    val yellow: Yellow?
)