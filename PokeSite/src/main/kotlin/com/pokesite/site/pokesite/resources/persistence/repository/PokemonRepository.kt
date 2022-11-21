package com.pokesite.site.pokesite.resources.persistence.repository

import com.pokesite.site.pokesite.resources.persistence.entity.PokemonEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PokemonRepository: JpaRepository<PokemonEntity, Int> {

    fun findByExternalId(externalId: Int): PokemonEntity?
    fun findByPokemonName(pokemonName: String): PokemonEntity?


}