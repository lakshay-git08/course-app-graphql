package com.example.course_app_graphql.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.course_app_graphql.entity.User;
import com.example.course_app_graphql.service.UserService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Controller
public class UserQueryResolver implements GraphQLQueryResolver {

    @Autowired
    UserService userService;

    @QueryMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
