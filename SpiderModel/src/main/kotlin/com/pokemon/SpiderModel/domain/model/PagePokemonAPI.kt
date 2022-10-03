package com.pokemon.SpiderModel.domain.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name="page")
@JsonIgnoreProperties(ignoreUnknown = true)
data class PagePokemonAPI(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val url: String?,
    val count: Int?,
    val next: String?,
    val previous: String?,
    @OneToMany(targetEntity=PokemonBase::class, mappedBy="page", fetch=FetchType.EAGER)
    val results: List<PokemonBase>?
)