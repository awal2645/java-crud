package com.example.demo.services.impl;

import com.example.demo.resources.user.UserGetResponse;
import com.example.demo.resources.user.UserPostRequest;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserGetResponse saveUser(UserPostRequest userPostRequest) {
        User user = mapToUser(userPostRequest);
        userRepository.save(user);
        return mapToUserGetResponse(user);
    }

    private UserGetResponse mapToUserGetResponse(User user) {
        UserGetResponse response =new UserGetResponse();
        response.setUserId(user.getId());
        response.setUserEmail(user.getEmail());
        response.setUserName(user.getName());
        return response;
    }

    private static User mapToUser(UserPostRequest userPostRequest) {
        User user =new User();
        user.setName(userPostRequest.getUserName());
        user.setEmail(userPostRequest.getUserEmail());
        return user;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, User userDetails) {
        return null;
    }

}
