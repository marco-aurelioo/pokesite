package com.pokesite.site.pokesite.resources.api.extensions

import com.pokesite.site.pokesite.domain.model.PokemonModel
import com.pokesite.site.pokesite.domain.model.PokemonTypeModel
import com.pokesite.site.pokesite.resources.api.model.Pokemon
import com.pokesite.site.pokesite.resources.api.model.Stat
import com.pokesite.site.pokesite.resources.api.model.Type
import com.pokesite.site.pokesite.resources.persistence.entity.PokemonEntity
import com.pokesite.site.pokesite.resources.persistence.entity.PokemonType

class PokemonApiExtensions

fun com.pokesite.site.pokesite.resources.api.model.Result.toPokemonItem(): PokemonModel {
    return PokemonModel(
        id = this.url.extractUrlId(),
        pokemonImg = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/${this.url.extractUrlId()}.svg",
        pokemonName = this.name,
        moves = null,
        hp = null,
        height = null,
        weight = null,
        attack = null,
        defense = null,
        specialAttack = null,
        specialDefense = null,
        speed = null,
        types = null
    )
}

fun Pokemon.toPokemonModel(): PokemonModel {
    return PokemonModel(
        id = this.id,
        pokemonImg = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/${this.id}.svg",
        pokemonName = this.name,
        moves = this.moves?.let { it.size }.run { null },
        hp = getStats("hp", this.stats),
        height = this.height,
        weight = this.weight,
        attack = getStats("attack", this.stats),
        defense = getStats("defense", this.stats),
        specialAttack = getStats("special-attack", this.stats),
        specialDefense = getStats("special-defense", this.stats),
        speed = getStats("speed", this.stats),
        types = this.types?.stream()?.map { PokemonTypeModel(extractTypeId(it.type!!.url!!),it.type!!.name!!) }?.toList()
    )
}

fun Pokemon.toEntity(): PokemonEntity = PokemonEntity(
    id = null,
    externalId = this.id,
    pokemonImg = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${this.id}.png",
    pokemonName = this.name!!,
    hp = getStats("hp", this.stats),
    height = this.height!!,
    weight = this.weight!!,
    attack = getStats("attack", this.stats),
    defense = getStats("defense", this.stats),
    specialAttack = getStats("special-attack", this.stats),
    specialDefense = getStats("special-defense", this.stats),
    speed = getStats("speed", this.stats),
    types = getTypes(this.types)
)

fun getTypes(types: List<Type>?): List<PokemonType>? {
    return types?.stream()?.map {
        var idType = extractTypeId(it.type!!.url!!)
        var typeName = it.type.name
        PokemonType(idType,typeName!!)
    }?.toList()
}

fun extractTypeId(url: String): Int {
    return url.replace(Regex("https://pokeapi.co/api/v2/type/(\\d+)/"),"$1").toInt()
}

fun PokemonEntity.toPokemonModel(): PokemonModel = PokemonModel(
    id =  this.externalId,
    pokemonName = this.pokemonName,
    pokemonImg = this.pokemonImg,
    height = this.height,
    hp = this.hp,
    weight = this.weight,
    attack = this.attack,
    defense = this.defense,
    specialDefense = this.specialDefense,
    specialAttack = this.specialAttack,
    moves = null,
    speed = this.speed,
    types = this.types?.stream()?.map { PokemonTypeModel(it.id,it.typeName) }?.toList()
)

fun getStats(statsName: String, stats: List<Stat>?): Int? {
    stats?.let { st ->
        val stResult = st.stream().filter()
         { it.stat!!.name == statsName }
            .findFirst()
        if(stResult.isEmpty)
            return null
        return stResult.get().base_stat
    }
    return null
}

fun String.extractUrlId(): Int {
    return this.replace(Regex("https://pokeapi.co/api/v2/pokemon/(\\d+)/"),"$1").toInt()
}