package com.sapient.controllers;

import com.sapient.entity.Book;
import com.sapient.entity.BookList;
import com.sapient.service.BookManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookManager mgr;

    @PostMapping(consumes = {"application/json", "application/xml"})
    public ResponseEntity<?> addNewBook(@RequestBody Book book){
        try {
            book = mgr.save(book);
        }
        catch(RuntimeException e){
            Map<String, Object> map = new HashMap<>();
            map.put("message", e.getMessage());
            map.put("timestamp", new Date().toString());
            map.put("book", book);
            map.put("status_code", 500);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping(produces = "application/json")
    public Iterable<Book> getBooksHandler(){
        return mgr.getAllBooks();
    }

    @GetMapping(produces = "application/xml")
    public BookList getBooksAsXmlHandler(){
        List<Book> books = new ArrayList<>();
        mgr.getAllBooks().forEach(books::add);
        return new BookList(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneBook(@PathVariable Integer id) {
        Book book = mgr.getBookById(id);
        if(book==null){
            Map<String, Object> map = new HashMap<>();
            map.put("message", "No data found for id: " + id);
            map.put("timestamp", new Date().toString());
            map.put("status_code", 404);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
        }
        else {
            return ResponseEntity.ok(book);
        }
    }


}
