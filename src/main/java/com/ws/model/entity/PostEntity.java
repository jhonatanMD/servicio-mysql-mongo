package com.ws.model.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "post")
@Data
public class PostEntity extends PanacheEntity {

    private String title;
    private String body;

}
