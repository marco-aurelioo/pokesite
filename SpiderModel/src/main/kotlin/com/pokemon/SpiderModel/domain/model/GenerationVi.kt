package com.pokemon.SpiderModel.domain.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name="generation_vi")
@JsonIgnoreProperties(ignoreUnknown = true)
data class GenerationVi(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="omegarubyalphasapphire_id")
    val omegarubyAlphasapphire: OmegarubyAlphasapphire,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="xy_id")
    val xy: XY
)