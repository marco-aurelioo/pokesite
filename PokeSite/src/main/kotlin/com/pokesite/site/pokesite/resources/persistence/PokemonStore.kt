package com.pokesite.site.pokesite.resources.persistence

import com.pokesite.site.pokesite.domain.model.MoveModel
import com.pokesite.site.pokesite.domain.model.PokemonModel
import com.pokesite.site.pokesite.resources.api.model.Move
import com.pokesite.site.pokesite.resources.api.model.Pokemon
import org.springframework.stereotype.Component

@Component
class PokemonStore {

    val dataBase: MutableMap<Int, PokemonModel> = mutableMapOf()
    val dataBasePokemon: MutableMap<Int, Pokemon> = mutableMapOf()
    val dataBasePokemonName: MutableMap<String, Pokemon> = mutableMapOf()
    fun finPokemonModelList(ids: List<PokemonModel>): List<PokemonModel> {
        var listReturn : MutableList<PokemonModel> = mutableListOf()
        ids.stream().forEach{ model ->
            dataBase.get(model.id)?.let {
                listReturn.add(it)
            } ?: run {
                listReturn.add(model.copy(pokemonName = "Novo"))
            }
        }
        return listReturn.toList()
    }

    fun savePokemonModel(pokemon: Pokemon){
        dataBase.put(pokemon.id,
        PokemonModel(
            id = pokemon.id,
            pokemonName = pokemon.name,
            pokemonImg = pokemon.sprites!!.other!!.official_artwork!!.front_default,
            moves = getMoves(pokemon.moves!!)
        ))
        dataBasePokemon.put(pokemon.id, pokemon)
        dataBasePokemonName.put(pokemon.name!!,pokemon)
    }

    private fun getMoves(moves: List<Move>): List<MoveModel>? {
        var moveList: MutableList<MoveModel> = mutableListOf()
        moves.stream().forEach {
            moveList.add(
            MoveModel(
                name = it.move!!.name,
                active = false ))
        }
        return moveList.toList()
    }

    fun findByPokemonId(pokemonId: Int): Pokemon? {
        return dataBasePokemon.get(pokemonId)
    }

    fun findByName(name: String): Pokemon? {
        return dataBasePokemonName.get(name)
    }

}