package com.pws.DBMongo.service;

import com.pws.DBMongo.entity.Book;
import com.pws.DBMongo.exception.IdNotFoundException;
import com.pws.DBMongo.exception.NoDataAvailableExcpetion;
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
    public Book updateBook(Book book, String bookId) {
        Optional<Book> optional = repository.findById(bookId);
        if(optional.isEmpty()){
        throw new IdNotFoundException("Invalid Book ID");
        }
        Book bu = optional.get();
        bu.setBookName(book.getBookName());
        bu.setAuthor(book.getAuthor());
        return repository.save(bu);
    }

    @Override
    public Book getBookById(String id) {
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
            throw new NoDataAvailableExcpetion("NO BOOKS AVAILABLE IN THE LIST");
        }
        return optional.get();
    }

    @Override
    public void deleteBook(String id) {
        Optional<Book> optional = repository.findById(id);
        if(optional.isEmpty()){
            throw new IdNotFoundException("Invalid Book ID");
        }
        repository.delete(optional.get());
    }
}
