package com.githubtools.demo.entity.dto;

public class CommitDTO {
    private final AuthorDTO author;
    private final String message;

    public CommitDTO(AuthorDTO author, String message){
        this.author = author;
        this.message = message;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }
}
