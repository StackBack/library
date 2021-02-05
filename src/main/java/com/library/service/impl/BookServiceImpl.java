package com.library.service.impl;

import com.library.domain.Book;
import com.library.exception.BookException;
import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.findById(id).orElseThrow(() -> new BookException("Not find book by id + " + id));
        bookRepository.deleteById(id);
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookException("Not found book by id =" + id));
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getFreeBook() {
        return bookRepository.findAllByCustomUserIsNull();
    }

    @Override
    public List<Book> getNotFreeBook() {
        return bookRepository.findAllByCustomUserIsNotNull();
    }
}
