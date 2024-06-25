package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.resources.user.UserGetResponse;
import com.example.demo.resources.user.UserPostRequest;

import java.util.List;

public interface UserService {
    List<User> getAllUsers() ;

    User getUserById(Long id);

    UserGetResponse saveUser(UserPostRequest userPostRequest);

    void deleteUser(Long id);

    User updateUser(Long id, User userDetails);
}
