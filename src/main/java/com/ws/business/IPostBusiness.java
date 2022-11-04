package com.ws.business;

import com.ws.model.dto.PostDto;

import java.util.List;

public interface IPostBusiness {
    List<PostDto> findAll();
    PostDto findById(Long id) throws Exception;
    PostDto save(PostDto postDto);
}
