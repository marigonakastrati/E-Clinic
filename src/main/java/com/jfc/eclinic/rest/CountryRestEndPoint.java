/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.rest;

import com.jfc.eclinic.dto.Country;
import com.jfc.eclinic.services.CountryService;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jfc
 */
@Path("country")
public class CountryRestEndPoint {

    @Inject
    CountryService countryService;

    @POST
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create( Country value) {
        try {
            countryService.create(value);
        } catch (Exception ex) {
            //TODO: add the exception value to the header...
        }
        return Response.ok().entity("Data is saved").build();
    }

    @GET
    @Path("find")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find() {
        JsonArray build = null;
        try {
            build = countryService.get().stream().map(h -> Json.createObjectBuilder()
                    .add("id", h.getCountryId())
                    .add("name", h.getCountryName())
                    .build())
                    .collect(Json::createArrayBuilder, JsonArrayBuilder::add, JsonArrayBuilder::add)
                    .build();
        } catch (Exception ex) {
            //TODO: add the exception value to the header...
        }
        return Response.ok().entity(build == null ? "No data found" : build).build();
    }

    @GET
    @Path("find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id")@Valid String id) {
        JsonObject build = null;
        try {
            Country get = countryService.get(Integer.valueOf(id));
            build = Json.createObjectBuilder().add("id", get.getCountryId()).add("name", get.getCountryName()).build();

        } catch (Exception ex) {
            //TODO: add the exception value to the header...
        }
        return Response.ok().entity(build == null ? "No data found" : build).build();
    }

    @DELETE
    @Path("delete/{id}")
    public Response delete(@PathParam("id") @Valid String id) {
        try {
            countryService.delete(Integer.valueOf(id));
        } catch (Exception ex) {
            //TODO: add the exception value to the header...
        }
        return Response.ok().entity("Date is deleted").build();
    }

    @PUT
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid Country value) {
        try {
            countryService.update(value);
        } catch (Exception ex) {
            //TODO: add the exception value to the header...
        }
        return Response.ok().entity("Date is updated").build();
    }

}
