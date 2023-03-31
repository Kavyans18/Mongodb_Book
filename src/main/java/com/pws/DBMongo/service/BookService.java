package com.pws.DBMongo.service;

import com.pws.DBMongo.entity.Book;

import java.util.List;

public interface BookService {
   public Book saveBook(Book book);
   public Book updateBook(Book book, String id);
   public Book getBookById(String id);
   public List<Book> getAllBooks();
   public void deleteBook(String id);

}
