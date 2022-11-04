package com.ws.proxy;

import com.ws.proxy.model.PostProxyDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@RegisterRestClient(configKey = "post-proxy")
public interface IPostProxy {

    //https://jsonplaceholder.typicode.com/posts/1
    @GET
    @Path("posts/{id}")
    PostProxyDto getById(@PathParam("id") Long id);


    //https://jsonplaceholder.typicode.com/posts
    @GET
    @Path("posts")
    List<PostProxyDto> getAll();

}
