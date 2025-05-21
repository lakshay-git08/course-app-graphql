package com.example.course_app_graphql.service;

import java.util.List;
import java.util.Optional;

import com.example.course_app_graphql.entity.Course;
import com.example.course_app_graphql.input.CourseInput;

public interface CourseService {

    public List<Course> getAllCourses(int page, int limit, String sortBy, int sortDirection);

    public Optional<Course> getCourseById(String id);

    public Course createCourse(CourseInput courseInput);

    public Course updateCourse(String id, CourseInput courseInput);

    public String deleteCourse(String id);

    public List<Course> getAllCoursesByCreatorId(String creatorId, int page, int limit, String sortBy,
            int sortDirection);

}
