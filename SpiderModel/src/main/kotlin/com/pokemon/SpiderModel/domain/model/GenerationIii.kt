package com.pokemon.SpiderModel.domain.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name="generation_iii")
@JsonIgnoreProperties(ignoreUnknown = true)
data class GenerationIii(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="emerald_id")
    val emerald: Emerald,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="fireredleaf-green_id")
    val fireredLeafgreen: FireredLeafgreen,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="rubyapphire_id")
    val rubySapphire: RubySapphire
)