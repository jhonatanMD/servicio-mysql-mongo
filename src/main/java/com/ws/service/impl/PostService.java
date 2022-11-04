package com.ws.service.impl;

import com.ws.mapper.IPostMapper;
import com.ws.model.dto.PostDto;
import com.ws.repository.PostRepository;
import com.ws.service.IPostService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@RequiredArgsConstructor
public class PostService implements IPostService {

    private final PostRepository repository;
    private final IPostMapper mapper;

    @Override
    public List<PostDto> findAll() {
        return repository.listAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto findById(Long id) {
        return mapper.toDto(repository.findById(id));
    }

    @Override
    @Transactional
    public PostDto save(PostDto postDto) {
        repository.persist(mapper.toEntity(postDto));
        return postDto;
    }

    @Override
    public PostDto update(PostDto postDto, Long id) {
        return null;
    }
}
