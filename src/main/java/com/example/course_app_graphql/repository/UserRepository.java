package com.example.course_app_graphql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.course_app_graphql.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
