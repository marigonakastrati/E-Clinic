/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.rest;

import com.jfc.eclinic.services.AddressService;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.validation.Valid;
import javax.ws.rs.Path;
import javax.validation.constraints.Size;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jfc
 */
@Path("address")
public class AddressRestEndPoint {

    @Inject AddressService addressService;
    

    @POST
    @Path("validate")
    public void addValid(@Valid @Size (max = 4, min = 2) String value) {
        System.out.println(value);
    }
    
    @GET
    @Path("addressList")
    public Response getAddress() throws Exception
    {
        JsonArray build = addressService.get().stream().map(h -> Json.createObjectBuilder()
                .add("id", h.getAddressId())
                .add("name", h.getStreetName())
                .build())
                .collect(Json::createArrayBuilder, JsonArrayBuilder::add, JsonArrayBuilder::add)
                .build();
        return Response.ok()
            .status(200).entity(build).build();
    }
    
    @POST
    @Path("edit")
    public Response editAddress(com.jfc.eclinic.dto.Address get) throws Exception
    {
        addressService.update(get);
        return Response.ok().build();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("type/{id}")
    public Response post(@PathParam("id")String id)
    {
        System.out.println(id);
        return Response.ok().entity("type POST"+ id).build();
    }
    @POST
    @Path("editAddress")
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(com.jfc.eclinic.dto.Address a) throws Exception
    {
        addressService.update(a);
        return Response.ok().build();
    }
}
