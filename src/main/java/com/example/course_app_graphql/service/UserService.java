package com.example.course_app_graphql.service;

import java.util.List;

import com.example.course_app_graphql.entity.User;
import com.example.course_app_graphql.input.UserFilter;
import com.example.course_app_graphql.input.UserInput;

public interface UserService {

    public List<User> getAllUsers(UserFilter filter);

    public User getUserById(String id);

    public User createUser(UserInput userInput);

    public User updateUser(String id, UserInput userInput);

    public String deleteUser(String id);
}
