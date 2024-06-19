package com.example.autenticacion.controller

import com.example.autenticacion.entity.IUser
import com.example.autenticacion.service.IUserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class IUserController(private val iUserService: IUserService) {

    @GetMapping("/{username}")
    fun getUser(@PathVariable username: String): ResponseEntity<IUser> {
        val user = iUserService.findByUsername(username)
        return if (user != null) {
            ResponseEntity.ok(user)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createUser(@RequestBody user: IUser): ResponseEntity<IUser> {
        val savedUser = iUserService.saveUser(user)
        return ResponseEntity.ok(savedUser)
    }

    @DeleteMapping("/{username}")
    fun deleteUser(@PathVariable username: String): ResponseEntity<Void> {
        iUserService.deleteUser(username)
        return ResponseEntity.noContent().build()
    }
}