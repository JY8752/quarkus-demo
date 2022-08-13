package com.example.data

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntityBase
import javax.persistence.*

@Entity(name = "user")
data class User(
    val name: String
    ) : PanacheEntityBase {
    companion object: PanacheCompanion<User> {
        fun findByName(name: String) = find("name", name).firstResult()
        fun deleteStefs() = delete("name", "Stef")
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int")
    var id: Long? = null
}