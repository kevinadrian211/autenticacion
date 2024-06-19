package com.example.autenticacion.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "IUser")
data class IUser(
    @Id
    val username: String,
    val password: String,
    val roles: String
)