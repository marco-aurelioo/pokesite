package com.pokesite.site.pokesite.resources.persistence.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    val id: Int,
    val username: String,
    val password: String,
    val role: String
)