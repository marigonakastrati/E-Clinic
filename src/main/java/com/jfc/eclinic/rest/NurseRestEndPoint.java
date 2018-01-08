/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.rest;

import com.jfc.eclinic.dto.Nurse;
import com.jfc.eclinic.services.NurseService;
import java.util.List;
import java.util.stream.Collectors;
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
@Path("nurse")
public class NurseRestEndPoint {

    @Inject
    NurseService nurseService;

    @POST
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid Nurse value) {
        try {
            nurseService.create(value);
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
            List<Nurse> get = nurseService.get();
            List<Nurse> collect = get.stream().filter(h -> h.getStatus() == Boolean.TRUE).collect(Collectors.toList());
            build = collect.stream().map(h -> Json.createObjectBuilder()
                    .add("firstname", h.getPersonId().getFirstName())
                    .add("lastname", h.getPersonId().getLastName())
                    .add("id", h.getNurseId())
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
            Nurse get = nurseService.get(Integer.valueOf(id));
            build = Json.createObjectBuilder()
                    .add("firstname", get.getPersonId().getFirstName())
                    .add("lastname", get.getPersonId().getLastName())
                    .add("id", get.getNurseId())
                    .build();

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
        System.out.println("delete"+ id);
        try {
            Nurse get = nurseService.get(Integer.valueOf(id));
            nurseService.delete(get);
        } catch (Exception ex) {
            return Response.ok().header("Exception", ex.getMessage()).build();
        }
        return Response.ok().entity("Data is deleted").build();
    }

    @POST
    @Path("deleteStatus/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response changeStatus(@PathParam("id") String id) throws Throwable {
        try {
            System.out.println("called Nurse");
            Nurse get = nurseService.get(Integer.valueOf(id));
            get.setStatus(Boolean.FALSE);
            nurseService.update(get);

        } catch (Exception ex) {
            return Response.ok().header("Exception", ex.getMessage()).build();
        }
        return Response.ok().entity("Date is updated").build();
    }

    @PUT
    @Path("updateName")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateName(Nurse value) throws Throwable {
        try {
           
        } catch (Exception ex) {
            return Response.ok().header("Exception", ex.getMessage()).build();
        }
        return Response.ok().entity("Date is updated").build();
    }

    /**
     *
     * @param value
     * @return
     * @throws Throwable
     */
    @PUT
    @Path("updatePassword")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePassword(Nurse value) throws Throwable {
        try {
    
        } catch (Exception ex) {
            return Response.ok().header("Exception", ex.getMessage()).build();
        }
        return Response.ok().entity("Date is updated").build();
    }
}
