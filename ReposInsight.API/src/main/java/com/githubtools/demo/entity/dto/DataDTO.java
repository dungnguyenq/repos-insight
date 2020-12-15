package com.githubtools.demo.entity.dto;

public class DataDTO {
    private final CommitDTO commit;
    private final Author1DTO author;
    private final String html_url;

    public DataDTO(CommitDTO commit, Author1DTO author, String html_url) {
        this.commit = commit;
        this.author = author;
        this.html_url = html_url;
    }

    public CommitDTO getCommit() {
        return commit;
    }

    public Author1DTO getAuthor() {
        return author;
    }

    public String getHtml_url() {
        return html_url;
    }
}
