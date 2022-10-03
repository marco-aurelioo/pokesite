package com.pokemon.SpiderModel.domain.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name="pokemon_url")
@JsonIgnoreProperties(ignoreUnknown = true)
data class PokemonBase(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: String?,
    val url: String?,
    @ManyToOne
    @JoinColumn(name="pageId")
    val page: PagePokemonAPI,
    val load: Boolean = false)
