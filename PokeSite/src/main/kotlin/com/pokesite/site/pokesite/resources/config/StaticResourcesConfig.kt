package com.pokesite.site.pokesite.resources.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport

@Configuration
class StaticResourcesConfig: WebMvcConfigurationSupport() {

    override fun addResourceHandlers(registry: ResourceHandlerRegistry){
        registry.addResourceHandler("/**")
            .addResourceLocations("classpath:/static/")

    }
}