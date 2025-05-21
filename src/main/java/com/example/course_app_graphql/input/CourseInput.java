package com.example.course_app_graphql.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseInput {

    private String name;

    @Builder.Default
    private Double price = 0.0;

    @Builder.Default
    private Double discounted_price = 0.0;

    private String duration;

    private String category;

    private String language;

    private String url;

    private String thumbnail_image;

    private String short_description;

    private String long_description;

}
