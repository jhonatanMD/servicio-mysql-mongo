package com.ws.repository.mongo;

import com.ws.model.document.PostDocument;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PostDocumentRepository implements PanacheMongoRepository<PostDocument> {

    public PostDocument findByIdPost(Long id){
        return find("post_id",id).firstResult();
    }
}
