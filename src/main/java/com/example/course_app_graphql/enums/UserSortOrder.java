package com.example.course_app_graphql.enums;

public enum UserSortOrder {

    ASC(1),
    DESC(-1);

    private final int sortOrder;

    UserSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getValue() {
        return this.sortOrder;
    }

    public UserSortOrder fromCode(int sortOrder) {
        // values() gives the array [ASC, DESC]
        for (UserSortOrder userSortOrder : values()) {
            // userSortOrder.sortOrder returns the int value of the given userSortOrder.
            if (userSortOrder.sortOrder == sortOrder) {
                return userSortOrder;
            }
        }
        throw new IllegalArgumentException("Unknown SortOrder: " + sortOrder);
    }
}
// ASC -> 1
// UserSortOrder.ASC.getSortOrder() gives 1 from ASC

// DESC -> -1
// UserSortOrder.DESC.getSortOrder() gives -1 from DESC

// 1 -> ASC
// UserSortOrder.fromCode(1) gives ASC from 1
