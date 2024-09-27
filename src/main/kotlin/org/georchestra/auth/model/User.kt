package org.georchestra.auth.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.CascadeType

import jakarta.persistence.CollectionTable
import jakarta.persistence.ElementCollection
import jakarta.persistence.Embedded
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.MapKeyJoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "users")
data class User (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var username: String = "",
    var password: String = "",
    var email: String = "",
    var enabled: Boolean = false,

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    var userRoles: List<UserRoles> = emptyList()
) {

    fun getRoles(): List<String> {
        return userRoles.map { "ROLE_${it.workgroup?.name}:${it.role?.name}" }
    }
}