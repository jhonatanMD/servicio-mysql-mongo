package com.ws.repository;

import com.ws.model.entity.PostEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PostRepository implements PanacheRepositoryBase<PostEntity,Long> {

}
