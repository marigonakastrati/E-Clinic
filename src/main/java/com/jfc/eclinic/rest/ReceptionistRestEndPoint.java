/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.jfc.eclinic.rest;

import com.jfc.eclinic.dto.Receptionist;
import com.jfc.eclinic.services.ReceptionistService;
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
 * @author mk
 */
@Path("receptionist")
public class ReceptionistRestEndPoint {

    @Inject
    ReceptionistService receptionistService;

    @POST
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid Receptionist value) {
        try {
            receptionistService.create(value);
        } catch (Exception ex) {
            return Response.ok().header("Exception", ex.getMessage()).build();
        }
        return Response.ok().entity("Data is saved").build();
    }

    @GET
    @Path("find")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find() {
        JsonArray build = null;
        try {
            build = receptionistService.get().stream().map(h -> Json.createObjectBuilder()
                    .add("id", h.getReceptionistId())
                    .add("name", h.getFirstName())
                    .build())
                    .collect(Json::createArrayBuilder, JsonArrayBuilder::add, JsonArrayBuilder::add)
                    .build();
        } catch (Exception ex) {
            return Response.ok().header("Exception", ex.getMessage()).build();
        }
        return Response.ok().entity(build == null ? "No data found" : build).build();
    }

    @GET
    @Path("find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") @Valid String id) {
        JsonObject build = null;
        try {
            Receptionist get = receptionistService.get(Integer.valueOf(id));
            build = Json.createObjectBuilder().add("id", get.getReceptionistId()).add("name", get.getFirstName()).build();

        } catch (Exception ex) {
            return Response.ok().header("Exception", ex.getMessage()).build();
        }
        return Response.ok().entity(build == null ? "No data found" : build).build();
    }

    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") String id) throws Throwable {
        try {
            Receptionist get = receptionistService.get(Integer.valueOf(id));
            receptionistService.delete(get);
        } catch (Exception ex) {
            return Response.ok().header("Exception", ex.getMessage()).build();
        }
        return Response.ok().entity("Data is deleted").build();
    }

    @PUT
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid Receptionist value) throws Throwable {
        try {
            receptionistService.update(value);
        } catch (Exception ex) {
            return Response.ok().header("Exception", ex.getMessage()).build();
        }
        return Response.ok().entity("Date is updated").build();
    }

}
