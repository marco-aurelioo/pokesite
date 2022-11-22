package com.pokesite.site.pokesite.resources.persistence

import com.pokesite.site.pokesite.domain.model.MoveModel
import com.pokesite.site.pokesite.domain.model.PokemonModel
import com.pokesite.site.pokesite.resources.api.extensions.toEntity
import com.pokesite.site.pokesite.resources.api.extensions.toPokemonModel
import com.pokesite.site.pokesite.resources.api.model.Move
import com.pokesite.site.pokesite.resources.api.model.Pokemon
import com.pokesite.site.pokesite.resources.persistence.entity.PokemonEntity
import com.pokesite.site.pokesite.resources.persistence.repository.PokemonRepository
import com.pokesite.site.pokesite.resources.persistence.repository.PokemonTypeRepository
import org.springframework.stereotype.Component

@Component
class PokemonStore(
    val repository: PokemonRepository,
    val pokemonTypeRepository: PokemonTypeRepository) {

     fun finPokemonModelList(ids: List<PokemonModel>): List<PokemonModel> {
        var listReturn : MutableList<PokemonModel> = mutableListOf()
        ids.stream().forEach{ model ->
            repository.findByExternalId(model.id!!)?.let {
                listReturn.add(it.toPokemonModel())
            } ?: run {
                listReturn.add(model.copy(pokemonName = "Novo"))
            }
        }
        return listReturn.toList()
    }

    fun savePokemonModel(pokemon: Pokemon){
       val pokemonEntity = pokemon.toEntity()
        pokemonEntity.types?.let {
            pokemonTypeRepository.saveAll(pokemonEntity.types)
        }
        repository.save(pokemonEntity)
    }

    fun findByPokemonId(pokemonId: Int): PokemonEntity? {
        return repository.findByExternalId(pokemonId)
    }

    fun findByName(name: String): PokemonModel? {
        return repository.findByPokemonName(name)?.toPokemonModel()
    }

}