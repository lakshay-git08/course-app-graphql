package com.example.course_app_graphql.enums;

public enum CourseSortBy {

    CATEGORY("category"),
    NAME("name");

    private final String sortBy;

    CourseSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getValue() {
        return sortBy;
    }

    public CourseSortBy fromValue(String sortBy) {
        for (CourseSortBy courseSortBy : values()) {
            if (courseSortBy.sortBy.equalsIgnoreCase(sortBy)) {
                return courseSortBy;
            }
        }
        throw new IllegalArgumentException("Unknown SortBy: " + sortBy);
    }

}
