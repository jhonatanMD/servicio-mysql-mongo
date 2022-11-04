package com.ws.service;

import com.ws.model.dto.PostDto;

import java.util.List;

public interface IPostDocumentService {

    List<PostDto> findAll();
    PostDto findById(Long id);
    PostDto save(PostDto postDto);
    PostDto update(PostDto postDto , Long id);

}
