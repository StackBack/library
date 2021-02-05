package com.library.service.impl;

import com.library.domain.Book;
import com.library.domain.CustomUser;
import com.library.exception.UserException;
import com.library.repository.BookRepository;
import com.library.repository.UserRepository;
import com.library.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public UserServiceImpl(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public CustomUser getCurrentUser(){
        return userRepository.findById(1l).orElseThrow(() -> new UserException("User not find"));
    }

    @Override
    public void createUser(CustomUser customUser) {
        userRepository.save(customUser);
    }

    @Override
    public CustomUser getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserException("User not exist"));
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        bookRepository.updateAllBooksByCustomUser_Id(id);
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(CustomUser user) {
        userRepository.save(user);
    }

    @Override
    public List<CustomUser> findAll() {
        return userRepository.findAll();
    }
}
