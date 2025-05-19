package com.example.course_app_graphql.input;

import com.example.course_app_graphql.enums.UserSortBy;
import com.example.course_app_graphql.enums.UserSortOrder;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class UserFilter {

    private int page = 1;

    private int limit = 5;

    private UserSortBy sortBy;

    private UserSortOrder sortOrder;
    // getSortOrder() return UserSortOrder

    // getter

    // public int getPage() {
    // return this.page;
    // }

    // setter

    // public void setPage(int page) {
    // this.page = page;
    // }

    public void print() {
        log.info("UserFilter: page = {}, limit = {}", this.page, this.limit);
    }
}

// sequence
// sortBy and sortOrder > limit > page