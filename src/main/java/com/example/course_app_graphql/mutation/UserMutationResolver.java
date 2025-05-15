package com.example.course_app_graphql.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.example.course_app_graphql.entity.User;
import com.example.course_app_graphql.input.UserInput;
import com.example.course_app_graphql.service.UserService;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Controller
public class UserMutationResolver implements GraphQLMutationResolver {

    @Autowired
    UserService userService;

    @MutationMapping
    public User createUser(UserInput userInput) {
        return userService.createUser(userInput);
    }

}
