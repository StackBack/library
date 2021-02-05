package com.library.controller;

import com.library.domain.Book;
import com.library.dto.ReturnBook;
import com.library.dto.UserTake;
import com.library.service.BookService;
import com.library.service.LibraryService;
import com.library.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library")
public class LibraryController {
    private final BookService bookService;
    private final UserService userService;
    private final LibraryService libraryService;

    public LibraryController(BookService bookService, UserService userService, LibraryService libraryService) {
        this.bookService = bookService;
        this.userService = userService;
        this.libraryService = libraryService;
    }

    @GetMapping("freebook")
    public List<Book> getFreeBook(){
        return bookService.getFreeBook();
    }

//    @GetMapping("notfreebook")
//    public List<Book> getNotFreeBook(){
//        return bookService.getNotFreeBook();
//    }

    @GetMapping("userWithBook")
    public List<Book> userHaveBook() {
        return bookService.getNotFreeBook();
    }

    @PutMapping("return")
    public void returnBook(@RequestBody ReturnBook returnBook){
        libraryService.returnBook(returnBook.getBookId());
    }

    @PutMapping("take")
    public void takeBook(@RequestBody UserTake user){
        libraryService.takeBook(user.getBookId(),user.getUserId());
    }
}
