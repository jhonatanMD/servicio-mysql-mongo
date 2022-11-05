package com.ws.controller;

import com.ws.business.IPostBusiness;
import com.ws.model.dto.ErrorResponse;
import org.apache.http.HttpStatus;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1")
public class AppController {

    @Inject
    @Named("PostBusiness")
    private IPostBusiness postBusiness;

    @GET
    @Path("/post/{id}")
    //@RolesAllowed("write")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPostById(@PathParam("id") Long id) {
        try {
            return Response.ok().entity(postBusiness.findById(id)).build();
        }catch (Exception e){
            return Response.status(HttpStatus.SC_CONFLICT).entity(new ErrorResponse(e.getMessage())).build();
        }

    }


    @GET
    @RolesAllowed("read")
    @Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPost() {
            return Response.ok().entity(postBusiness.findAll()).build();
    }
}