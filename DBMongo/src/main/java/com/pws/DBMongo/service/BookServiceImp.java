package com.pws.DBMongo.service;

import com.pws.DBMongo.entity.Book;
import com.pws.DBMongo.exception.IdNotFoundException;
import com.pws.DBMongo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService{
    @Autowired
    BookRepository repository;

    @Override
    public Book saveBook(Book book) {
        return repository.save(book);
    }

    @Override
    public Book updateBook(Book book, int id) {
        Optional<Book> optional = repository.findById(id);
        if(optional.isEmpty()){
        throw new IdNotFoundException("Invalid Book ID");
        }
        Book bu = optional.get();
        bu.setBookId(book.getBookId());
        bu.setBookName(book.getBookName());
        bu.setAuthor(book.getAuthor());
        return repository.save(bu);
    }

    @Override
    public Book getBookById(int id) {
        Optional<Book> optional = repository.findById(id);
        if(optional.isEmpty()){
            throw new IdNotFoundException("Invalid Book ID");
        }
        return optional.get();
    }

    @Override
    public List<Book> getAllBooks() {
        Optional<List<Book>> optional = Optional.of(repository.findAll());
        if(optional.isEmpty()) {
            System.out.println("No books available");
            return null;
        }
        return repository.findAll();
    }

    @Override
    public void deleteBook(int id) {
        Optional<Book> optional = repository.findById(id);
        if(optional.isEmpty()){
            throw new IdNotFoundException("Invalid Book ID");
        }
        repository.delete(optional.get());
    }
}
