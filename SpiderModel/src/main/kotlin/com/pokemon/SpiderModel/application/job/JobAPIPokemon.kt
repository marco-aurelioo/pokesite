package com.pokemon.application.job

import org.springframework.scheduling.annotation.Scheduled

class JobAPIPokemon {

    @Scheduled(fixedDelay = 3000)
    fun runJob(){
        println() {"run job"}
    }

}