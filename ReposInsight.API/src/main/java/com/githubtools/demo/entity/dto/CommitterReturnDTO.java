package com.githubtools.demo.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommitterReturnDTO {
    @JsonProperty("display_name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("github_username")
    private String githubUsername;

    @JsonProperty("github_avaurl")
    private String githubAvaUrl;

    @JsonProperty("github_profile")
    private String githubProfile;

    @JsonProperty("commit_count")
    private long commitCount;

    public CommitterReturnDTO(String name, String email, String githubUsername, String githubAvaUrl, String githubProfile, long commitCount) {
        this.name = name;
        this.email = email;
        this.githubUsername = githubUsername;
        this.githubAvaUrl = githubAvaUrl;
        this.githubProfile = githubProfile;
        this.commitCount = commitCount;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
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

    public long getCommitCount() {
        return commitCount;
    }

    //    @Override
//    public boolean equals(Object obj) {
//        if (!(obj instanceof CommitterReturnDTO)) {
//            return false;
//        }
//
//        CommitterReturnDTO that = (CommitterReturnDTO) obj;
//
//        return this.id.equals(that.getId())
//                && this.login.equals(that.getLogin());
//    }
//
//    @Override public int hashCode() {
//        return Objects.hash(id,login);
//    }

}
