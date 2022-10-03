package com.pokemon.SpiderModel.resources

import com.pokemon.SpiderModel.domain.model.PokemonBase
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface PokemonBaseRepository: CrudRepository<PokemonBase, Int> {

    fun findByLoad(load: Boolean): List<PokemonBase>

    fun findByUrl(url: String): Optional<PokemonBase>

}