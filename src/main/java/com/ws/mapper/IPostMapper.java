package com.ws.mapper;

import com.ws.model.document.PostDocument;
import com.ws.model.dto.PostDto;
import com.ws.model.entity.PostEntity;
import com.ws.proxy.model.PostProxyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface IPostMapper {
    PostDto toDto(PostEntity postEntity);
    @Mapping(target = "id" , ignore = true)
   // @Mapping(source = "postId" , target = "id")
    PostDto toDto(PostDocument postDocument);
    PostDto toProxyDto(PostProxyDto postProxyDto);
    PostProxyDto toDto(PostDto postDto);
    PostEntity toEntity(PostDto postDto);
    @Mapping(target = "id" , ignore = true)
    PostDocument toDocument(PostDto postDto);
}
