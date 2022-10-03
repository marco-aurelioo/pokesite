package com.pokemon.SpiderModel.application.job

import com.fasterxml.jackson.databind.ObjectMapper
import com.pokemon.SpiderModel.domain.model.PagePokemonAPI
import com.pokemon.SpiderModel.resources.PokePageRepository
import com.pokemon.SpiderModel.resources.PokemonBaseRepository
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity


@Component
class JobAPIPokemon(
    val repository: PokePageRepository,
    val baseRepository: PokemonBaseRepository
) {

    var restTemplate = RestTemplate()
    var baseUrl: String = "https://pokeapi.co/api/v2/pokemon"
    var objectMapper = ObjectMapper()
    @Scheduled(fixedDelay = 30000 )
    fun runJob(){
        println("run job")

        var url: String? = baseUrl
        while(!url.isNullOrBlank()){
            println("load $url")
            var page = getPage(url!!)
            var page_optional = repository.findByUrl(url!!)
            if(!page_optional.isPresent) {
                var pageEntity = repository.save(page.copy(url = url))
                page.results!!.forEach {
                    val base = it.copy(page = pageEntity)
                    baseRepository.save(base)
                }
            }else{
                page.results!!.forEach {
                    val entity = baseRepository.findByUrl(it.url!!)
                    if(entity.isEmpty) {
                        val base = it.copy(page = page_optional.get())
                        baseRepository.save(base)
                    }
                }
            }
            url = page.next

        }

        println("fim")
    }

    fun getPage(url: String): PagePokemonAPI {
        var response = restTemplate.getForEntity<String>(url)
        return objectMapper.readValue(response.body, PagePokemonAPI::class.java)
    }

}