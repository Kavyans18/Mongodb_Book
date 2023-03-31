package com.pws.DBMongo.util;

import com.pws.DBMongo.entity.Book;
import com.pws.DBMongo.service.BookServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertCallback;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class MyIdGenerator implements BeforeConvertCallback<Book> {

    @Override
    public Book onBeforeConvert(Book entity, String collection) {
        if(entity.getBookId() == null || entity.getBookId().isEmpty()) {
            entity.setBookId("book"+ UUID.randomUUID().toString());
        }
        return entity;
    }
}
