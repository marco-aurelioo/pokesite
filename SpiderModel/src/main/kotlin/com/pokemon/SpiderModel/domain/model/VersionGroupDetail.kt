package com.pokemon.SpiderModel.domain.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name="version_group_detail")
@JsonIgnoreProperties(ignoreUnknown = true)
data class VersionGroupDetail(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val level_learned_at: Int,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="movelearnmethod_id")
    val move_learn_method: MoveLearnMethod,
    @ManyToOne(cascade= arrayOf(CascadeType.PERSIST))
    @JoinColumn(name="versiongroup_id")
    val version_group: VersionGroup,
    @ManyToOne
    @JoinColumn(name="move_id")
    val move: Move
)