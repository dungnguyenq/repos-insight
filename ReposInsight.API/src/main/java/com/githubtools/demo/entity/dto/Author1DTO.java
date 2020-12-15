package com.githubtools.demo.entity.dto;

public class Author1DTO {

    private final String login;
    private final String avatar_url;
    private final String html_url;

    public Author1DTO(String login, String id, String avatar_url, String html_url) {
        this.login = login;
        this.avatar_url = avatar_url;
        this.html_url = html_url;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getHtml_url() {
        return html_url;
    }
}
