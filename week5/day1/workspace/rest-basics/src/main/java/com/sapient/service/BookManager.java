package com.sapient.service;

import com.sapient.entity.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookManager {
    private Map<Integer, Book> books;

    public BookManager() {
        books = new HashMap<>();
        books.put(1, new Book(1, "Let us C", 299.0));
        books.put(2, new Book(2, "Coding best practices", 899.0));
        books.put(3, new Book(3, "Docker unleashed", 599.0));
    }

    public Book getBookById(Integer id) {
        return this.books.get(id);
    }

    public Book save(Book book) {
        if(this.books.containsKey(book.getId())){
            throw new RuntimeException("There is already a book with this id: " + book.getId());
        }
        this.books.put(book.getId(), book);
        return book;
    }

    public Book deleteBookById(Integer id) {
        if (this.books.containsKey(id)) {
            Book book = this.books.get(id);
            this.books.remove(id);
            return book;
        }
        return null;
    }

    public Iterable<Book> getAllBooks() {
        return this.books.values();
    }
}
