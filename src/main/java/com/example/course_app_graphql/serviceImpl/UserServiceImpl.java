package com.example.course_app_graphql.serviceImpl;

import java.util.List;

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

        User userFromDB = userRepository.findById(id).orElse(null);

        if (userFromDB != null) {

            if (userInput.getName() != null) {
                userFromDB.setName(userInput.getName());
            }

            if (userInput.getPhone() != 0) {
                userFromDB.setPhone(userInput.getPhone());
            }

            if (userInput.getEmail() != null) {
                userFromDB.setEmail(userInput.getEmail());
            }
            if (userInput.getUsername() != null) {
                userFromDB.setUsername(userInput.getUsername());
            }
        }
        User updatedUser = userRepository.save(userFromDB);
        return updatedUser;

    }

}
