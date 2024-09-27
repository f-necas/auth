package org.georchestra.auth.controller

import org.georchestra.auth.UserService
import org.georchestra.auth.model.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(val userService: UserService) {

    @GetMapping("/users-roles")
    fun getUsersWithRoles() : List<User> {
        return userService.getUserWithRoles()
    }
}