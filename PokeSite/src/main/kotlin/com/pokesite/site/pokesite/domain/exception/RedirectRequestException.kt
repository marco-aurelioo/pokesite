package com.pokesite.site.pokesite.domain.exception

import com.pokesite.site.pokesite.resources.api.model.Pokemon

class RedirectRequestException(pokemon: Pokemon): Exception(pokemon.name) {
}