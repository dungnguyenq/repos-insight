package com.githubtools.demo.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class CommitReturnDTO {
    @JsonProperty("title")
    private String title;

    @JsonProperty("commit_url")
    private String commitUrl;

    @JsonProperty("created_date")
    private Date createdDate;

    @JsonProperty("github_username")
    private String githubUsername;

    @JsonProperty("github_avaurl")
    private String githubAvaUrl;

    @JsonProperty("github_profile")
    private String githubProfile;

    public CommitReturnDTO(String title, String commitUrl, Date createdDate, String githubUsername, String githubAvaUrl, String githubProfile) {
        this.title = title;
        this.commitUrl = commitUrl;
        this.createdDate = createdDate;
        this.githubUsername = githubUsername;
        this.githubAvaUrl = githubAvaUrl;
        this.githubProfile = githubProfile;
    }

    public String getTitle() {
        return title;
    }

    public String getCommitUrl() {
        return commitUrl;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getGithubUsername() {
        return githubUsername;
    }

    public String getGithubAvaUrl() {
        return githubAvaUrl;
    }

    public String getGithubProfile() {
        return githubProfile;
    }
}
