package com.example.autenticacion.repository

import com.example.autenticacion.entity.IUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IUserRepository : JpaRepository<IUser, String> {
    fun findByUsername(username: String): IUser?
}