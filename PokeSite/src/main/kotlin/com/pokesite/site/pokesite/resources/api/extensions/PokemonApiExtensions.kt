package com.pokesite.site.pokesite.resources.api.extensions

import com.pokesite.site.pokesite.domain.model.PokemonModel
import com.pokesite.site.pokesite.domain.model.PokemonTypeModel
import com.pokesite.site.pokesite.resources.api.model.Pokemon
import com.pokesite.site.pokesite.resources.api.model.Sprites
import com.pokesite.site.pokesite.resources.api.model.Stat
import com.pokesite.site.pokesite.resources.api.model.Type
import com.pokesite.site.pokesite.resources.persistence.entity.PokemonEntity
import com.pokesite.site.pokesite.resources.persistence.entity.PokemonImgs
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
    types = getTypes(this.types),
    pokemonImgs = getImgs(this.id,this.sprites)
)

fun getImgs(id: Int, sprites: Sprites?): PokemonImgs? =
    sprites?.let {
        return PokemonImgs(
            id = id,
            back_default = it.back_default,
            back_female = it.back_female,
            back_shiny = it.back_shiny,
            back_shiny_female = it.back_shiny_female,
            front_default = it.front_default,
            front_female = it.front_female,
            front_shiny = it.front_shiny,
            front_shiny_female = it.front_shiny_female,
            dream_world_front_default = it.other?.dream_world?.front_default,
            dream_world_front_female = it.other?.dream_world?.front_female,
            home_front_default = it.other?.home?.front_default,
            home_front_female = it.other?.home?.front_female,
            home_front_shiny = it.other?.home?.front_shiny,
            home_front_shiny_female = it.other?.home?.front_shiny_female,
            official_artwork_front_default = it.other?.official_artwork?.front_default,
            red_blue_back_default = it.versions?.generationI?.redBlue?.back_default,
            red_blue_back_gray = it.versions?.generationI?.redBlue?.back_gray,
            red_blue_back_transparent = it.versions?.generationI?.redBlue?.back_transparent,
            red_blue_front_default = it.versions?.generationI?.redBlue?.front_default,
            red_blue_front_gray = it.versions?.generationI?.redBlue?.front_gray,
            red_blue_front_transparent = it.versions?.generationI?.redBlue?.front_transparent,
            yellow_back_default = it.versions?.generationI?.yellow?.back_default,
            back_gray_back_transparent = it.versions?.generationI?.yellow?.back_transparent,
            back_gray_front_default = it.versions?.generationI?.yellow?.front_gray,
            back_gray_front_gray = it.versions?.generationI?.yellow?.front_gray,
            back_gray_front_transparent = it.versions?.generationI?.yellow?.front_transparent,
            crystal_back_default = it.versions?.generationIi?.crystal?.back_default,
            crystal_back_shiny = it.versions?.generationIi?.crystal?.back_shiny,
            crystal_back_shiny_transparent = it.versions?.generationIi?.crystal?.back_shiny_transparent,
            crystal_back_transparent = it.versions?.generationIi?.crystal?.back_transparent,
            crystal_front_default = it.versions?.generationIi?.crystal?.front_default,
            crystal_front_shiny = it.versions?.generationIi?.crystal?.front_shiny,
            crystal_front_shiny_transparent = it.versions?.generationIi?.crystal?.front_shiny_transparent,
            crystal_front_transparent = it.versions?.generationIi?.crystal?.front_transparent,
            gold_back_default = it.versions?.generationIi?.gold?.back_default,
            gold_back_shiny = it.versions?.generationIi?.gold?.back_shiny,
            gold_front_default = it.versions?.generationIi?.gold?.front_default,
            gold_front_shiny = it.versions?.generationIi?.gold?.front_shiny,
            gold_front_transparent = it.versions?.generationIi?.gold?.front_transparent,
            silver_back_default = it.versions?.generationIi?.silver?.back_default,
            silver_back_shiny = it.versions?.generationIi?.silver?.back_shiny,
            silver_front_default = it.versions?.generationIi?.silver?.front_default,
            silver_front_shiny = it.versions?.generationIi?.silver?.front_shiny,
            silver_front_transparent = it.versions?.generationIi?.silver?.front_transparent,
            emerald_front_default = it.versions?.generationIii?.emerald?.front_default,
            emerald_front_shiny = it.versions?.generationIii?.emerald?.front_shiny,
            firered_leafgreen_back_default = it.versions?.generationIii?.fireredLeafgreen?.back_default,
            firered_leafgreen_back_shiny = it.versions?.generationIii?.fireredLeafgreen?.back_shiny,
            firered_leafgreen_front_default = it.versions?.generationIii?.fireredLeafgreen?.front_default,
            firered_leafgreen_front_shiny = it.versions?.generationIii?.fireredLeafgreen?.front_shiny,
            ruby_sapphire_back_default = it.versions?.generationIii?.rubySapphire?.back_default,
            ruby_sapphire_back_shiny = it.versions?.generationIii?.rubySapphire?.back_shiny,
            ruby_sapphire_front_default = it.versions?.generationIii?.rubySapphire?.front_default,
            ruby_sapphire_front_shiny = it.versions?.generationIii?.rubySapphire?.front_shiny,
            diamond_pearl_back_default = it.versions?.generationIv?.diamondPearl?.back_default,
            diamond_pearl_back_female = it.versions?.generationIv?.diamondPearl?.back_female,
            diamond_pearl_back_shiny = it.versions?.generationIv?.diamondPearl?.back_shiny,
            diamond_pearl_back_shiny_female = it.versions?.generationIv?.diamondPearl?.back_shiny_female,
            diamond_pearl_front_default = it.versions?.generationIv?.diamondPearl?.front_default,
            diamond_pearl_front_female = it.versions?.generationIv?.diamondPearl?.front_female,
            diamond_pearl_front_shiny = it.versions?.generationIv?.diamondPearl?.front_shiny,
            diamond_pearl_front_shiny_female = it.versions?.generationIv?.diamondPearl?.front_shiny_female,
            heartgold_soulsilver_back_default = it.versions?.generationIv?.heartgoldSoulsilver?.back_default,
            heartgold_soulsilver_back_female = it.versions?.generationIv?.heartgoldSoulsilver?.back_female,
            heartgold_soulsilver_back_shiny = it.versions?.generationIv?.heartgoldSoulsilver?.back_shiny,
            heartgold_soulsilver_back_shiny_female = it.versions?.generationIv?.heartgoldSoulsilver?.back_shiny_female,
            heartgold_soulsilver_front_default = it.versions?.generationIv?.heartgoldSoulsilver?.front_default,
            heartgold_soulsilver_front_female = it.versions?.generationIv?.heartgoldSoulsilver?.front_female,
            heartgold_soulsilver_front_shiny = it.versions?.generationIv?.heartgoldSoulsilver?.front_shiny,
            heartgold_soulsilver_front_shiny_female = it.versions?.generationIv?.heartgoldSoulsilver?.front_shiny_female,
            platinum_back_default = it.versions?.generationIv?.platinum?.back_default,
            platinum_back_female = it.versions?.generationIv?.platinum?.back_female,
            platinum_back_shiny = it.versions?.generationIv?.platinum?.back_shiny,
            platinum_back_shiny_female = it.versions?.generationIv?.platinum?.back_shiny_female,
            platinum_front_default = it.versions?.generationIv?.platinum?.front_default,
            platinum_front_female = it.versions?.generationIv?.platinum?.front_female,
            platinum_front_shiny = it.versions?.generationIv?.platinum?.front_shiny,
            platinum_front_shiny_female = it.versions?.generationIv?.platinum?.front_shiny_female,
            black_white_animated_back_default = it.versions?.generationV?.blackWhite?.animated?.back_default,
            black_white_animated_back_female = it.versions?.generationV?.blackWhite?.animated?.back_female,
            black_white_animated_back_shiny = it.versions?.generationV?.blackWhite?.animated?.back_shiny,
            black_white_animated_back_shiny_female = it.versions?.generationV?.blackWhite?.animated?.back_shiny_female,
            black_white_animated_front_default = it.versions?.generationV?.blackWhite?.animated?.front_default,
            black_white_animated_front_female = it.versions?.generationV?.blackWhite?.animated?.front_female,
            black_white_animated_front_shiny = it.versions?.generationV?.blackWhite?.animated?.front_shiny,
            black_white_animated_front_shiny_female = it.versions?.generationV?.blackWhite?.animated?.front_shiny_female,
            black_white_back_default = it.versions?.generationV?.blackWhite?.back_default,
            black_white_back_female = it.versions?.generationV?.blackWhite?.back_female,
            black_white_back_shiny = it.versions?.generationV?.blackWhite?.back_shiny,
            black_white_back_shiny_female = it.versions?.generationV?.blackWhite?.back_shiny_female,
            black_white_front_default = it.versions?.generationV?.blackWhite?.front_default,
            black_white_front_female = it.versions?.generationV?.blackWhite?.front_female,
            black_white_front_shiny = it.versions?.generationV?.blackWhite?.front_shiny,
            black_white_front_shiny_female = it.versions?.generationV?.blackWhite?.front_shiny_female,
            omegaruby_alphasapphire_front_default = it.versions?.generationVi?.omegarubyAlphasapphire?.front_default,
            omegaruby_alphasapphire_front_female = it.versions?.generationVi?.omegarubyAlphasapphire?.front_female,
            omegaruby_alphasapphire_front_shiny = it.versions?.generationVi?.omegarubyAlphasapphire?.front_shiny,
            omegaruby_alphasapphire_front_shiny_female = it.versions?.generationVi?.omegarubyAlphasapphire?.front_shiny_female,
            x_y_front_default = it.versions?.generationVi?.xY?.front_default,
            x_y_front_female = it.versions?.generationVi?.xY?.front_female,
            x_y_front_shiny = it.versions?.generationVi?.xY?.front_shiny,
            x_y_front_shiny_female = it.versions?.generationVi?.xY?.front_shiny_female,
            generation_vii_icons_front_default = it.versions?.generationVii?.icons?.front_default,
            generation_vii_icons_front_female = it.versions?.generationVii?.icons?.front_female,
            ultra_sun_ultra_moon_front_default = it.versions?.generationVii?.ultraSunUltraMoon?.front_default,
            ultra_sun_ultra_moon_front_female = it.versions?.generationVii?.ultraSunUltraMoon?.front_female,
            ultra_sun_ultra_moon_front_shiny = it.versions?.generationVii?.ultraSunUltraMoon?.front_shiny,
            ultra_sun_ultra_moon_front_shiny_female = it.versions?.generationVii?.ultraSunUltraMoon?.front_shiny_female,
            generation_viii_icons_front_default = it.versions?.generationViii?.icons?.front_default,
            generation_viii_icons_front_female = it.versions?.generationViii?.icons?.front_female
        )
    }

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