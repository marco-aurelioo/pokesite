package com.pokemon.SpiderModel.domain.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(name="move")
@JsonIgnoreProperties(ignoreUnknown = true)
data class Move(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @ManyToOne
    val move: MoveX,
    @OneToMany(targetEntity= VersionGroupDetail::class, mappedBy="move", fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    val version_group_details: List<VersionGroupDetail>,
    @ManyToOne
    @JoinColumn(name="pokemon_id")
    val pokemon: Pokemon
)