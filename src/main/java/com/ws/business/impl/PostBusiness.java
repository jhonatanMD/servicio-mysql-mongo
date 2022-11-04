package com.ws.business.impl;

import com.ws.business.IPostBusiness;
import com.ws.mapper.IPostMapper;
import com.ws.model.dto.PostDto;
import com.ws.proxy.IPostProxy;
import com.ws.service.IPostService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Named("PostBusiness")
@ApplicationScoped
public class PostBusiness implements IPostBusiness {

    @Inject
    private IPostService postService;

    @Inject
    @RestClient
    private IPostProxy postProxy;

    @Inject
    private IPostMapper mapper;

    @Override
    public List<PostDto> findAll() {
        return postProxy.getAll()
                .stream().map(mapper::toProxyDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto findById(Long id) throws Exception {

        PostDto  postDto =  postService.findById(id);
        log.info("post data bd => " + postDto);
        if(postDto == null){
            PostDto postP = mapper.toProxyDto(postProxy.getById(id));
            log.info("post data proxy => " + postP);
            if(postP != null) {
                postService.save(postP);
                return postP;
            }

            throw new Exception("No se encontro Post con el id => " + id);
        }

        return postDto;
    }

    @Override
    public PostDto save(PostDto postDto) {
        return null;
    }
}
