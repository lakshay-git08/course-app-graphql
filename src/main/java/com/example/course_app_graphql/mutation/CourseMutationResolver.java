package com.example.course_app_graphql.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.example.course_app_graphql.entity.Course;
import com.example.course_app_graphql.input.CourseInput;
import com.example.course_app_graphql.input.UserInput;
import com.example.course_app_graphql.service.CourseService;
import com.example.course_app_graphql.service.UserService;

@Controller
public class CourseMutationResolver {

    @Autowired
    CourseService courseService;

    @MutationMapping
    public Course createCourse(@Argument CourseInput input) {
        return courseService.createCourse(input);
    }

    @MutationMapping
    public Course updateCourse(@Argument String id, @Argument(name = "input") CourseInput courseInput) {
        return courseService.updateCourse(id, courseInput);
    }

    @MutationMapping
    public String deleteCourse(@Argument String id) {
        return courseService.deleteCourse(id);
    }

}
