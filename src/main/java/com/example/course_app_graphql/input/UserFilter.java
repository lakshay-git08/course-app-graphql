package com.example.course_app_graphql.input;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class UserFilter {

    public int page = 1;

    public int limit = 5;

    public String sortBy = "name";

    public int sortOrder = 1;

    public void print() {
        log.info("UserFilter: page = {}, limit = {}", this.page, this.limit);
    }
}
