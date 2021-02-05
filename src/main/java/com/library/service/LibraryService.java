package com.library.service;

public interface LibraryService {
    void returnBook(Long bookId);
    void takeBook(Long bookId, Long userId);
}
