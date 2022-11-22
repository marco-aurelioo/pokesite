package com.pokesite.site.pokesite.resources.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "pokemon_type")
data class PokemonType(
    @Id
    var id: Int,
    var typeName: String
)