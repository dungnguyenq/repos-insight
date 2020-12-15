package com.githubtools.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "committer")
public class Committer implements Serializable {
    private static final long serialVersionUID = -2343243243242432341L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "github_display_name")
    private String githubDisplayName;

    @Column(name = "github_username")
    private String githubUsername;

    @Column(name = "github_email")
    private String githubEmail;

    @Column(name = "github_ava_url")
    private String githubAvaUrl;

    @Column(name = "github_profile_url")
    private String githubProfileUrl;

    @Column(name = "commit_count")
    private int commitCount;

    public Committer(){ super();}

    public int getId() {
        return id;
    }

    public String getGithubDisplayName() {
        return githubDisplayName;
    }

    public void setGithubDisplayName(String githubDisplayName) {
        this.githubDisplayName = githubDisplayName;
    }

    public String getGithubUsername() {
        return githubUsername;
    }

    public void setGithubUsername(String githubUsername) {
        this.githubUsername = githubUsername;
    }

    public String getGithubEmail() {
        return githubEmail;
    }

    public void setGithubEmail(String githubEmail) {
        this.githubEmail = githubEmail;
    }

    public String getGithubAvaUrl() {
        return githubAvaUrl;
    }

    public void setGithubAvaUrl(String githubAvaUrl) {
        this.githubAvaUrl = githubAvaUrl;
    }

    public String getGithubProfileUrl() {
        return githubProfileUrl;
    }

    public void setGithubProfileUrl(String githubProfileUrl) {
        this.githubProfileUrl = githubProfileUrl;
    }

    public int getCommitCount() {
        return commitCount;
    }

    public void setCommitCount(int commitCount) {
        this.commitCount = commitCount;
    }

    public void setCommitter(String githubDisplayName, String githubUsername, String githubEmail, String githubAvaUrl, String githubProfileUrl, int commitCount) {
        this.githubDisplayName = githubDisplayName;
        this.githubUsername = githubUsername;
        this.githubEmail = githubEmail;
        this.githubAvaUrl = githubAvaUrl;
        this.githubProfileUrl = githubProfileUrl;
        this.commitCount = commitCount;
    }
}
