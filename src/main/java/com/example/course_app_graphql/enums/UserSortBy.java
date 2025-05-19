package com.example.course_app_graphql.enums;

public enum UserSortBy {

    EMAIL("email"),
    NAME("name");

    private final String sortBy;

    UserSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getValue() {
        return sortBy;
    }

    public UserSortBy fromValue(String sortBy) {
        for (UserSortBy userSortBy : values()) {
            if (userSortBy.sortBy.equalsIgnoreCase(sortBy)) {
                return userSortBy;
            }
        }
        throw new IllegalArgumentException("Unknown SortBy: " + sortBy);
    }
}
