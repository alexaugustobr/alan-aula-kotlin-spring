package com.example.demo

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*

@RestController
class UserController(
        val userService: UserService
) {

    @GetMapping("/users/{id}")
    fun findById(@PathVariable id: UUID) : User? {
        return userService.findById(id)
    }

    @GetMapping("/users")
    fun listarUsers() : List<User> {
        return userService.listAllUsers()
    }

    @PostMapping("/users")
    fun criarUsers(@RequestBody user: User) : ResponseEntity<Unit> {

        val savedUser = userService.create(user)

        return ResponseEntity.created(URI.create("/users/${savedUser.id}")).build()
    }

}