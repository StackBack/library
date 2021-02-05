package com.library.service;

import com.library.domain.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);
    void deleteBook(Long id);
    Book getBook(Long id);
    void updateBook(Book book);
    List<Book> findAll();
    List<Book> getFreeBook();
    List<Book> getNotFreeBook();
}
