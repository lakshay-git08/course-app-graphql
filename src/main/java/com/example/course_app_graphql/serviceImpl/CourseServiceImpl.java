package com.example.course_app_graphql.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.course_app_graphql.entity.Course;
import com.example.course_app_graphql.entity.User;
import com.example.course_app_graphql.input.CourseInput;
import com.example.course_app_graphql.repository.CourseRepository;
import com.example.course_app_graphql.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Course> getAllCourses(int page, int limit, String sortBy, int sortDirection) {
        Sort sort = Sort.unsorted();
        if (!sortBy.equals("")) {
            Sort.Direction direction = sortDirection == 1 ? Sort.Direction.ASC
                    : sortDirection == -1 ? Sort.Direction.DESC : null;
            sort = direction == null ? Sort.unsorted() : Sort.by(direction, sortBy);
        }

        Pageable pageable = PageRequest.of(page - 1, limit, sort);

        return courseRepository.findAll(pageable).getContent();
    };

    @Override
    public Optional<Course> getCourseById(String id) {
        return courseRepository.findById(id);
    };

    @Override
    public Course createCourse(CourseInput courseInput) {
        Course course = Course.builder().name(courseInput.getName())
                .price(courseInput.getPrice())
                .discounted_price(courseInput.getDiscounted_price())
                .duration(courseInput.getDuration())
                .category(courseInput.getCategory())
                .language(courseInput.getLanguage())
                .url(courseInput.getUrl())
                .thumbnail_image(courseInput.getThumbnail_image())
                .short_description(courseInput.getShort_description())
                .long_description(courseInput.getLong_description())
                .build();

        return courseRepository.save(course);
    };

    @Override
    public Course updateCourse(String id, CourseInput courseInput) {
        Course courseFromDB = courseRepository.findById(id).orElse(null);

        if (courseFromDB != null) {

            if (courseInput.getName() != null) {
                courseFromDB.setName(courseInput.getName());
            }
            if (courseInput.getPrice() != 0) {
                courseFromDB.setPrice(courseInput.getPrice());
            }
            if (courseInput.getDiscounted_price() != 0) {
                courseFromDB.setDiscounted_price(courseInput.getDiscounted_price());
            }
            if (courseInput.getDuration() != null) {
                courseFromDB.setDuration(courseInput.getDuration());
            }
            if (courseInput.getCategory() != null) {
                courseFromDB.setCategory(courseInput.getCategory());
            }
            if (courseInput.getLanguage() != null) {
                courseFromDB.setLanguage(courseInput.getLanguage());
            }
            if (courseInput.getUrl() != null) {
                courseFromDB.setUrl(courseInput.getUrl());
            }
            if (courseInput.getThumbnail_image() != null) {
                courseFromDB.setThumbnail_image(courseInput.getThumbnail_image());
            }
            if (courseInput.getShort_description() != null) {
                courseFromDB.setShort_description(courseInput.getShort_description());
            }
            if (courseInput.getLong_description() != null) {
                courseFromDB.setLong_description(courseInput.getLong_description());
            }
        }
        Course updatedCourse = courseRepository.save(courseFromDB);
        return updatedCourse;
    }

    @Override
    public String deleteCourse(String id) {
        Course courseFromDB = courseRepository.findById(id).orElse(null);
        if (courseFromDB != null) {
            courseRepository.deleteById(id);
            return "Course deleted successfully.";
        }
        return "Course not deleted.";
    }

    @Override
    public List<Course> getAllCoursesByCreatorId(String creatorId, int page, int limit, String sortBy,
            int sortDirection) {

        Sort sort = Sort.unsorted();
        if (!sortBy.equals("")) {
            Sort.Direction direction = sortDirection == 1 ? Sort.Direction.ASC
                    : sortDirection == -1 ? Sort.Direction.DESC : null;
            sort = direction == null ? Sort.unsorted() : Sort.by(direction, sortBy);
        }

        Pageable pageable = PageRequest.of(page - 1, limit, sort);

        List<Course> coursesFromDB = courseRepository.findAllCoursesByCreatorId(creatorId, pageable);
        return coursesFromDB;
    }

}
