package com.pws.DBMongo.controller;

import com.pws.DBMongo.entity.Book;
import com.pws.DBMongo.service.BookServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    @Autowired
    BookServiceImp service;

    @PostMapping("/save")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        logger.info("From class name: {}, Accessing saveBook method to Save a Book",
                this.getClass().getSimpleName() );
        service.saveBook(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable String id) {
        logger.info("From class name: {}, Accessing updateBook method to update a book",
                this.getClass().getSimpleName() );
        service.updateBook(book, id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String bookId) {
        logger.info("From class name: {}, Accessing getBookById method to fetch the details of the book using bookId",
                this.getClass().getSimpleName() );
       Book book = service.getBookById(bookId);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAll(){
        logger.info("From class name: {}, Accessing getAll method to fetch the details of all the books available in database",
                this.getClass().getSimpleName() );
        List<Book> book =  service.getAllBooks();
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable String id) {
        logger.info("From class name: {}, Accessing deleteBook method to delete the details of the book using bookId",
                this.getClass().getSimpleName() );
        service.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
