package com.example.resource

import com.example.data.User
import com.fasterxml.jackson.databind.ObjectMapper
import io.quarkus.test.TestTransaction
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test
import javax.transaction.Transactional

@QuarkusTest
@Transactional
internal class UserResourceTest {
    @Test
    fun test() {
        given()
            .pathParam("id", 1)
            .`when`().get("/user/{id}")
            .then()
            .statusCode(200)
            .body(`is`("""
                {"id":1,"name":"user"}
            """.trimIndent()))
    }
}