package com.pws.DBMongo.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Data
@Document(collection = "Books")
public class Book {
    @Id
    private int bookId;
    @Field(name = "book_name")
    private String bookName;
    private String author;

}
