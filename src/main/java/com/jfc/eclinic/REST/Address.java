/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.REST;

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

/**
 *
 * @author jfc
 */
@Path("address")
public class Address {

    @Inject AddressService addressService;
    

    @POST
    @Path("validate")
    public void addValid(@Valid @Size (max = 4, min = 2) String value) {
        System.out.println(value);
    }
    
    @GET
    @Path("addressList")
    public JsonArray getAddress() throws Exception
    {
        return addressService.get().stream().map(h -> Json.createObjectBuilder()
                .add("Address Id", h.getAddressId())
                .add("Address Name", h.getStreetName())
                .build())
                .collect(Json::createArrayBuilder, JsonArrayBuilder::add, JsonArrayBuilder::add)
                .build();

    }
}
