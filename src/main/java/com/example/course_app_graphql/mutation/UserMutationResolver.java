package com.example.course_app_graphql.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
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
    public User createUser(@Argument UserInput input) {
        return userService.createUser(input);
    }

    @MutationMapping
    public User updateUser(@Argument String id, @Argument(name = "input") UserInput userInput) {
        return userService.updateUser(id, userInput);
    }

    @MutationMapping
    public String deleteUser(@Argument String id) {
        return userService.deleteUser(id);
    }

}

// @Argument binds the parameter with graphql mapping. It should match with the
// field in the mutation.graphqls
