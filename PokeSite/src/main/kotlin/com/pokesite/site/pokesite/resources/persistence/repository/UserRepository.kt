package com.pokesite.site.pokesite.resources.persistence.repository

import com.pokesite.site.pokesite.resources.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserEntity, Int> {

    fun findByUsername(username: String): UserEntity?
}