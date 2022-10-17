package com.pokesite.site.pokesite.resources.api.model

data class Move(
    val move: com.pokesite.site.pokesite.resources.api.model.MoveX?,
    val version_group_details: List<com.pokesite.site.pokesite.resources.api.model.VersionGroupDetail>?
)