package com.example.course_app_graphql.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course_app_graphql.entity.User;
import com.example.course_app_graphql.input.UserInput;
import com.example.course_app_graphql.repository.UserRepository;
import com.example.course_app_graphql.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();

    }

    @Override
    public User createUser(UserInput userInput) {

        User user = User.builder()
                .name(userInput.getName())
                .dob(userInput.getDob())
                .phone(userInput.getPhone())
                .email(userInput.getEmail())
                .roleType(0)
                .username(userInput.getUsername())
                .password(userInput.getPassword()).build();
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String id, UserInput userInput) {

        Optional<User> userFromDB = userRepository.findById(id);
        if (userFromDB != null) {
            
        }
        return null;
    }

}
