package com.example.data

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.quarkus.test.TestTransaction
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Test
import javax.transaction.Transactional

@QuarkusTest
@TestTransaction
internal class UserTest {
    @Test
    fun test() {
        //given
        val user = User().also {
            it.name = "user"
            it.persist()
        }

        //when
        val find = User.findById(user.id!!)

        //then
        find shouldBe user
    }
}