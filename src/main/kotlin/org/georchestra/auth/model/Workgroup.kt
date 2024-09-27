package org.georchestra.auth.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.ElementCollection
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
import java.sql.Timestamp

@Entity
@Table(name = "workgroups")
data class Workgroup(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var name: String = "",
    var created_at: Timestamp? = null,


    @JsonIgnore
    @OneToMany(mappedBy = "workgroup", fetch = FetchType.LAZY)
    var userRoles: List<UserRoles> = emptyList()
) {
    fun getUsers(): List<User> {
        return userRoles.map { it.user!! }
    }

}