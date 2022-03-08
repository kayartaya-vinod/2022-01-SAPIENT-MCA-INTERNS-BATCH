package com.sapient.controllers;

import com.sapient.dao.BookDao;
import com.sapient.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookDao dao;

    @PostMapping
    public Book create(@RequestBody Book book) {
        log.trace("BookController.create() called with {}", book);
        book.setId(null);
        return dao.save(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> retrieve(@PathVariable Integer id){
        log.trace("BookController.retrieve() called with {}", id);
        Optional<Book> result = dao.findById(id);
        if(result.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No book for id " + id + " found!");
        }
        return ResponseEntity.ok(result.get());
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Integer id, @RequestBody Book book) {
        log.trace("BookController.update() called with {} and {}", id, book);
        book.setId(id);
        return dao.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        log.trace("BookController.delete() called with {}", id);
        dao.deleteById(id);
    }

    @GetMapping
    public Iterable<Book> getAll(){
        log.trace("BookController.getAll() called");
        return dao.findAll();
    }
}
