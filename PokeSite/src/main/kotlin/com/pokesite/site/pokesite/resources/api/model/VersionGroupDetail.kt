package com.pokesite.site.pokesite.resources.api.model

data class VersionGroupDetail(
    val level_learned_at: Int?,
    val move_learn_method: com.pokesite.site.pokesite.resources.api.model.MoveLearnMethod?,
    val version_group: com.pokesite.site.pokesite.resources.api.model.VersionGroup?
)