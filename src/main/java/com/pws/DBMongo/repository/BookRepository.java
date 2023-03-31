package com.pws.DBMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pws.DBMongo.entity.Book;
public interface BookRepository extends MongoRepository<Book, String> {

}
