package com.example.demo.controllers.impl;

import com.example.demo.resources.user.UserGetResponse;
import com.example.demo.resources.user.UserPostRequest;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controllers.UserController;
import com.example.demo.entities.User;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController{

    @Autowired
    private UserService userService;

    /**
     * We are getting all users from database
     * */
    @Override
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * We are getting single user by filtering the Id
     * */
    @Override
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok( userService.getUserById(id));
    }

    @Override
    public ResponseEntity<UserGetResponse> createUser(@RequestBody UserPostRequest userPostRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(userPostRequest));
    }

    @Override
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
      return ResponseEntity.ok(userService.updateUser(id,userDetails));
    }

    @Override
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
    
}
