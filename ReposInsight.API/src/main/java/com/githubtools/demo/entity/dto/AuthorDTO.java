package com.githubtools.demo.entity.dto;

import java.util.Date;

public class AuthorDTO {

    private final String name;
    private final String email;
    private final Date date;

    public AuthorDTO(String name, String email, Date date) {
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getDate() {
        return date;
    }
}
