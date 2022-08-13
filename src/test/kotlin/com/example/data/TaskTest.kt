package com.example.data

import io.kotest.matchers.shouldBe
import io.quarkus.test.TestTransaction
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Test

@QuarkusTest
@TestTransaction
class TaskTest {
    @Test
    fun test() {
        //given
        val user = User("user").also { it.persist() }
        val task = Task(user = user, details = "task").also { it.persist() }

        //when
        val find = Task.findById(task.id!!)

        //then
        find shouldBe task
    }
}