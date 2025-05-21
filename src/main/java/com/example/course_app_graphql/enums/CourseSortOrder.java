package com.example.course_app_graphql.enums;

public enum CourseSortOrder {
    ASC(1),
    DESC(-1);

    private final int sortOrder;

    CourseSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getValue() {
        return this.sortOrder;
    }

    public CourseSortOrder fromCode(int sortOrder) {
        for (CourseSortOrder CourseSortOrder : values()) {
            if (CourseSortOrder.sortOrder == sortOrder) {
                return CourseSortOrder;
            }
        }
        throw new IllegalArgumentException("Unknown SortOrder: " + sortOrder);
    }
}
