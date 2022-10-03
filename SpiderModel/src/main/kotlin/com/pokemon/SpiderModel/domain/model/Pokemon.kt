package com.pokemon.SpiderModel.model

import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(name="pokemon")
data class Pokemon(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Int,
    // val held_items: List<Any>,
    // val past_types: List<Any>,
    @OneToMany(targetEntity= Ability::class, mappedBy="pokemon", fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    val abilities: List<Ability>,
    @OneToMany(targetEntity= Indices::class, mappedBy="pokemon", fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    val game_indices: List<Indices>,
    @OneToMany(targetEntity= Forms::class, mappedBy="pokemon", fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    val forms: List<Forms>,
    @OneToMany(targetEntity= Move::class, mappedBy="pokemon", fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    val moves: List<Move>,
    @OneToMany(targetEntity= Stat::class, mappedBy="pokemon", fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    val stats: List<Stat>,
    @OneToMany(targetEntity= Type::class, mappedBy="pokemon", fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    val types: List<Type>,

    val base_experience: Int,
    val height: Int,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val name: String,
    val order: Int,
    val species: Species,
    val sprites: Sprites,
    val weight: Int
)