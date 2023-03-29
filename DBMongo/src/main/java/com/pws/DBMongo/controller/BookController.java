package com.pws.DBMongo.controller;

import com.pws.DBMongo.entity.Book;
import com.pws.DBMongo.service.BookServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookServiceImp service;

    @PostMapping("/save")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        service.saveBook(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable int id) {
        service.updateBook(book, id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
       Book book = service.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAll(){
        List<Book> book =  service.getAllBooks();
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable int id) {
        service.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
