package com.pokesite.site.pokesite.resources.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "pokemon")
data class PokemonEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val externalId: Int,
    val pokemonName: String ,
    val pokemonImg: String,
    val weight: Int?,
    val height: Int?,
    val hp: Int?,
    val attack: Int?,
    val defense: Int?,
    val specialAttack: Int?,
    val specialDefense: Int?,
    val speed: Int?,
    @ManyToMany
    @JoinTable(
        name = "pokemon_pokemon_type",
        joinColumns = [JoinColumn(name = "pokemon_id")],
        inverseJoinColumns = [JoinColumn(name = "pokemon_type_id")])
    val types: List<PokemonType>?)