package com.example.course_app_graphql.entity;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    @Id
    private String id = UUID.randomUUID().toString();

    private String name;

    private Date dob;

    private long phone;

    private String email;

    private int roleType;

    private int status;

    private String username;

    @JsonIgnore
    private String password;

    private Date createdAt;

    private Date updatedAt;

}