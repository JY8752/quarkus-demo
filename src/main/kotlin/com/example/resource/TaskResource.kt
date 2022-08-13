package com.example.resource

import com.example.data.Task
import com.example.data.User
import com.fasterxml.jackson.annotation.JsonProperty
import javax.transaction.Transactional
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.Response

@Path("/task")
class TaskResource {

    @POST
    @Transactional
    @Produces("application/json")
    @Consumes("application/json")
    fun create(request: CreateTaskRequest): Response {
        val user = User.findById(request.userId) ?: kotlin.run {
            return Response.status(403).build()
        }
        val task = Task(user, request.details).also { it.persist() }
        return Response.ok(task).build()
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    fun get(@PathParam("id") id: Long): Response {
        val task = Task.findById(id) ?: kotlin.run {
            return Response.status(404).build()
        }
        return Response.ok(task).build()
    }
}

data class CreateTaskRequest(
    @JsonProperty("user_id")
    val userId: Long,
    val details: String)