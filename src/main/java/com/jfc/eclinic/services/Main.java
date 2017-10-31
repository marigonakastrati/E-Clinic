/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author F
 */
@Path("login")
public class Main {

    @GET
    @Path("/msg")
    public String msg() {
        return "Message";
    }

}
