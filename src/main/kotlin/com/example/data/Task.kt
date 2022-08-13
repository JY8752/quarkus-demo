package com.example.data

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntityBase
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "task")
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int")
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user_id1")
    val user: User,

    @Column(name = "details", columnDefinition = "text")
    val details: String,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
) : PanacheEntityBase {
    companion object : PanacheCompanion<Task>
}