package com.pokemon.SpiderModel.domain.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name="versons")
@JsonIgnoreProperties(ignoreUnknown = true)
data class Versions(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="generationi_id")
    val generation_i: GenerationI,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="generationii_id")
    val generation_ii: GenerationIi,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="generationiii_id")
    val generation_iii: GenerationIii,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="generationiv_id")
    val generation_iv: GenerationIv,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="generationv_id")
    val generation_v: GenerationV,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="generationvi_id")
    val generation_vi: GenerationVi,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="generationvii_id")
    val generation_vii: GenerationVii,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="generationviii_id")
    val generation_viii: GenerationViii
)