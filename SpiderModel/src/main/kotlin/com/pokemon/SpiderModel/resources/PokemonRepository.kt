package com.pokemon.SpiderModel.resources

import com.pokemon.SpiderModel.domain.model.Pokemon
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PokemonRepository: CrudRepository<Pokemon,Int> {
}