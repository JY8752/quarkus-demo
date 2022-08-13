package com.example.resource

import com.example.data.User
import javax.transaction.Transactional
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.Response

@Path("/user")
class UserResource {
    @POST
    @Transactional
    @Produces("application/json")
    @Consumes("application/json")
    fun create(name: String): Response {
        val user = User().also {
            it.name = name
            it.persist()
        }
        return Response.ok(user).build()
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    fun get(@PathParam("id") id: Long): Response {
        val user = User.findById(id)
        return Response.ok(user).build()
    }
}
