package com.ws.service;

import com.ws.mapper.IPostMapper;
import com.ws.model.dto.PostDto;
import com.ws.model.entity.PostEntity;
import com.ws.repository.PostRepository;
import io.quarkus.mongodb.panache.PanacheQuery;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;


@QuarkusTest
public class PostServiceTest {


    @Inject
    private IPostService postService;

    @InjectMock
    private PostRepository repository;

    @InjectMock
    private  IPostMapper mapper;


    @Test
    public void findAllTest(){

        Mockito.when(repository.listAll())
                .thenReturn(Arrays.asList(PostEntity.builder().body("este es un post").title("este es un test de post").build()));

        Mockito.when(mapper.toDto(PostEntity.builder().body("este es un post").title("este es un test de post").build()))
                .thenReturn(PostDto.builder().body("este es un post").title("este es un test de post").build());


        List<PostDto> responseTest = postService.findAll();

        Assertions.assertEquals(1,responseTest.size());

    }


    @Test
    public void findById(){

        Mockito.when(repository.findById(Mockito.anyLong()))
                .thenReturn(PostEntity.builder().body("este es un post").title("este es un test de post").build());

        Mockito.when(mapper.toDto(PostEntity.builder().body("este es un post").title("este es un test de post").build()))
                .thenReturn(PostDto.builder().body("este es un post").title("este es un test de post").build());


        PostDto responseTest = postService.findById(1L);

        Assertions.assertEquals("este es un post error al responser",responseTest.getBody());

    }


}
