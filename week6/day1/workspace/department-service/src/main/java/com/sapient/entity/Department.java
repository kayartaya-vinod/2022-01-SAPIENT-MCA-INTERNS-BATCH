package com.sapient.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "departments")
public class Department {
    @Id
    private Integer id;
    @Field(name = "DNAME")
    private String name;
    @Field(name = "LOC")
    private String location;
}
