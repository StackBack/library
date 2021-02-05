package com.library.service.impl;

import com.library.domain.Book;
import com.library.exception.BookException;
import com.library.exception.UserException;
import com.library.repository.BookRepository;
import com.library.repository.UserRepository;
import com.library.service.LibraryService;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService{
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public LibraryServiceImpl(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void returnBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookException("Book not find"));
        book.setCustomUser(null);
        bookRepository.save(book);
    }

    @Override
    public void takeBook(Long bookId, Long userId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookException("Book not find"));
        if(book.getCustomUser() == null){
            book.setCustomUser(userRepository.findById(userId).orElseThrow(() -> new UserException("User not find")));
            bookRepository.save(book);
        } else {
            throw new BookException("Date not valid");
        }
    }
}
