package com.pokesite.site.pokesite.domain.service

import com.pokesite.site.pokesite.domain.model.PublicidadeModel
import org.springframework.stereotype.Service
import java.util.*
import java.util.logging.Logger

@Service
class PublicidadeService {

    var log = Logger.getLogger(this.javaClass.name)
    fun findPublicidade(pagina: String ): List<PublicidadeModel> {
        log.info("publicidade para $pagina")
        return Arrays.asList( PublicidadeModel(),  PublicidadeModel());
    }
}