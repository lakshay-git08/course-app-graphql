package com.example.course_app_graphql.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.course_app_graphql.entity.User;
import com.example.course_app_graphql.input.UserFilter;
import com.example.course_app_graphql.service.UserService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Controller
public class UserQueryResolver implements GraphQLQueryResolver {

    @Autowired
    UserService userService;

    @QueryMapping
    public List<User> getAllUsers(@Argument UserFilter filter) {
        return userService.getAllUsers(filter);
    }

    @QueryMapping
    public User getUserById(@Argument String id) {
        return userService.getUserById(id);
    }
}
