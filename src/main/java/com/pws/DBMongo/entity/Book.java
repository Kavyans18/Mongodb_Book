package com.pws.DBMongo.entity;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Data
@Document(collection = "Books")
public class Book {
    @Id
    private String bookId;
    @Field(name = "book_name")
    @NonNull
    private String bookName;
    @Field(name = "author_name")
    @NonNull
    private String author;

}
