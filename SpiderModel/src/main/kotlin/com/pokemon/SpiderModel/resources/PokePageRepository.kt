package com.pokemon.SpiderModel.resources

import com.pokemon.SpiderModel.domain.model.PagePokemonAPI
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface PokePageRepository: CrudRepository<PagePokemonAPI,Int> {

    fun findByUrl(url: String): Optional<PagePokemonAPI>


}