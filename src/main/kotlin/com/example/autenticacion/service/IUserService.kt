package com.example.autenticacion.service

import com.example.autenticacion.entity.IUser
import com.example.autenticacion.repository.IUserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class IUserService(private val iUserRepository: IUserRepository) {

    @Transactional(readOnly = true)
    fun findByUsername(username: String): IUser? {
        return iUserRepository.findByUsername(username)
    }

    @Transactional
    fun saveUser(user: IUser): IUser {
        return iUserRepository.save(user)
    }

    @Transactional
    fun deleteUser(username: String) {
        iUserRepository.deleteById(username)
    }
}