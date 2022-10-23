package com.pokesite.site.pokesite.resources.api.model

data class HeldItem(
    val item: Item?,
    val version_details: List<VersionDetail?>?
)