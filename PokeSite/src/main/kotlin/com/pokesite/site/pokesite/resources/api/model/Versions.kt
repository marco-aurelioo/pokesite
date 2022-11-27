package com.pokesite.site.pokesite.resources.api.model

import com.fasterxml.jackson.annotation.JsonAlias

data class Versions(
    @JsonAlias("generation-i")
    val generationI: GenerationI?,
    @JsonAlias("generation-ii")
    val generationIi: GenerationIi?,
    @JsonAlias("generation-iii")
    val generationIii: GenerationIii?,
    @JsonAlias("generation-iv")
    val generationIv: GenerationIv?,
    @JsonAlias("generation-v")
    val generationV: GenerationV?,
    @JsonAlias("generation-vi")
    val generationVi: GenerationVi?,
    @JsonAlias("generation-vii")
    val generationVii: GenerationVii?,
    @JsonAlias("generation-viii")
    val generationViii: GenerationViii?
)