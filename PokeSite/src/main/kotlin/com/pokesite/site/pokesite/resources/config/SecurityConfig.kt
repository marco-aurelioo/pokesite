package com.pokesite.site.pokesite.resources.config

import com.pokesite.site.pokesite.domain.service.CustomUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter()  {

    @Autowired
    lateinit var userDetailsService : CustomUserDetailsService

    @Bean
    fun authenticationProvider(): AuthenticationProvider {
        val provider = DaoAuthenticationProvider()
        provider.setUserDetailsService(userDetailsService())
        provider.setPasswordEncoder(passwordEncoder())
        return provider
    }

    @Bean
    override fun userDetailsService(): UserDetailsService {
        return userDetailsService
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        var bpcrypt = BCryptPasswordEncoder()
        var exemplo = bpcrypt.encode("1234567")
        System.out.println("Exemplo!!!: $exemplo")
        return bpcrypt
    }

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .antMatchers("/users/**", "/games/**").authenticated()
            .anyRequest().permitAll()
            .and()
            .formLogin()
            .and()
            .logout()
            .and()
            .csrf().disable();
    }
}