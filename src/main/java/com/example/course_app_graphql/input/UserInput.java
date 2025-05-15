package com.example.course_app_graphql.input;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserInput {

    private String name;

    private Date dob;

    private long phone;

    private String email;

    private int roleType;

    private String username;

    @JsonIgnore
    private String password;

}
