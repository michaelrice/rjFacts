package com.toastcoders.rjfacts

import groovy.json.JsonSlurper
import javax.ws.rs.core.MediaType

import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.PathParam
import javax.ws.rs.core.Response

import com.toastcoders.util.WebResponse


@Produces('application/json')


@Path('/api/fact')
class FactResource {

    def FactService

    @GET
    Response getFact() {
        def fact = FactService.getRandomFact()
        WebResponse.ok(fact)
    }

    @POST
    Response createFact(Fact fact) {
        WebResponse.created(FactService.createNewFact(fact))
    }

    @DELETE
    @Path('/{id}')
    Response deleteFact(@PathParam('id') int id) {
        FactService.deleteFact(id)
    }

    @GET
    @Path('/{id}')
    Response getFactById(@PathParam("id") int id) {
        WebResponse.ok(FactService.getTaskById(id))
    }
}