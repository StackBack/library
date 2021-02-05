package com.library.controller;

import com.library.domain.Book;
import com.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("rest/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book create(@RequestBody @Valid Book book){
        bookService.createBook(book);
        return book;
    }

    @GetMapping
    public List<Book> getAll(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable Long id){
        return bookService.getBook(id);
    }

    @PutMapping
    public void update(@RequestBody Book book){
        bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        bookService.deleteBook(id);
    }
}
