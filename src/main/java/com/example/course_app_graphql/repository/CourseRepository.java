package com.example.course_app_graphql.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.course_app_graphql.entity.Course;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {

    @Query(" { created_by: ?0 } ")
    public List<Course> findAllCoursesByCreatorId(String creatorId, Pageable pageable);
}
