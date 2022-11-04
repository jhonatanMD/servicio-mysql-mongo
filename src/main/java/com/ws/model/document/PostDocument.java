package com.ws.model.document;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

@Data
@MongoEntity(collection = "Post")
public class PostDocument {

    @BsonId
    private ObjectId id;

    @BsonProperty("post_id")
    private Long postId;
    private String title;
    private String body;
}
