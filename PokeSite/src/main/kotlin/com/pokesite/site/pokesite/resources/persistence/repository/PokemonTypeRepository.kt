package com.pokesite.site.pokesite.resources.persistence.repository

import com.pokesite.site.pokesite.resources.persistence.entity.PokemonType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PokemonTypeRepository: JpaRepository<PokemonType,Int> {

}