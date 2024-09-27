package org.georchestra.auth

import org.georchestra.auth.model.User
import org.georchestra.auth.repository.UserRepository
import org.georchestra.auth.repository.WorkgroupRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository, val workgroupRepository: WorkgroupRepository) {

    fun getUserWithRoles() : List<User>  {
        val tmp = userRepository.findAll().forEach { user ->
            println("User: ${user.username}")
            println("Roles: ${user.getRoles()}")
        }
        return userRepository.findAll()
    }
}