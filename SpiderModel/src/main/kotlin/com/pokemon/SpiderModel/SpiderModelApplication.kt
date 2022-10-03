package com.pokemon.SpiderModel

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class SpiderModelApplication

fun main(args: Array<String>) {
	runApplication<SpiderModelApplication>(*args)
}
