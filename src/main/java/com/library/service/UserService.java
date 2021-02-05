package com.library.service;

import com.library.domain.CustomUser;

import java.util.List;

public interface UserService {
    void createUser(CustomUser customUser);
    CustomUser getUser(Long id);
    void deleteUser(Long id);
    void updateUser(CustomUser user);
    List<CustomUser> findAll();
}
