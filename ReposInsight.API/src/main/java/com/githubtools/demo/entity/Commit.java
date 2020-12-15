package com.githubtools.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "commit")
public class Commit implements Serializable {
    private static final long serialVersionUID = -2343243243242432341L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "commit_url")
    private String commitUrl;

    @Column(name = "github_username")
    private String githubUsername;

    @Column(name = "commit_date")
    private Date commitDate;

    public Commit(){ super();}

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCommitUrl() {
        return commitUrl;
    }

    public Date getcommitDate() {
        return commitDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCommitUrl(String commitUrl) {
        this.commitUrl = commitUrl;
    }

    public void setCommitDate(Date commitDate) {
        this.commitDate = commitDate;
    }

    public String getGithubUsername() {
        return githubUsername;
    }

    public void setGithubUsername(String githubUsername) {
        this.githubUsername = githubUsername;
    }

    public Date getCommitDate() {
        return commitDate;
    }
}
