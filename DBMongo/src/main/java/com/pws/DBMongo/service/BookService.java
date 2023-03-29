package com.pws.DBMongo.service;

import com.pws.DBMongo.entity.Book;

import java.util.List;

public interface BookService {
   public Book saveBook(Book book);
   public Book updateBook(Book book, int id);
   public Book getBookById(int id);
   public List<Book> getAllBooks();
   public void deleteBook(int id);

}
