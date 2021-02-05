package com.library.controller;

import com.library.domain.CustomUser;
import com.library.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("rest/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public CustomUser create(@RequestBody @Valid CustomUser customUser){
        userService.createUser(customUser);
        return customUser;
    }

    @GetMapping
    public List<CustomUser> get(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public CustomUser get(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PutMapping()
    public void update(@RequestBody CustomUser customUser){
        userService.updateUser(customUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
