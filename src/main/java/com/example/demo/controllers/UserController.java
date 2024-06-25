package com.example.demo.controllers;

import java.util.List;

import com.example.demo.resources.user.UserGetResponse;
import com.example.demo.resources.user.UserPostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.services.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public interface UserController {

    @GetMapping
    ResponseEntity<List<User>> getAllUsers();

    @GetMapping("/{id}")
    ResponseEntity<User> getUserById(@PathVariable Long id);

    @PostMapping("/save")
    ResponseEntity<UserGetResponse> createUser(@RequestBody UserPostRequest userPostRequest);

    @PutMapping("/{id}")
    ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userPostRequest);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Long id);
}
